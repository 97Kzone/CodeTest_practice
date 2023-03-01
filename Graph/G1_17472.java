package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class G1_17472 {
    static int N, M, cnt, res; // cnt = 섬 개수
    static int[] p; // union - find
    static int[][] board;
    static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static ArrayList<int[]> edges;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        edges = new ArrayList<>();

        int v;
        cnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                v = Integer.parseInt(st.nextToken());
                if (v == 1) board[i][j] = ++cnt;
            }
        }

        makeSet();
        check();
        Collections.sort(edges, (o1, o2) -> (o1[2] - o2[2]));
        
        res = 0;
        for (int[] e : edges) {
            if(!union(e[0], e[1])) continue;
            res += e[2];
            if (--cnt == 1) break;
        }

        System.out.println(cnt == 1 ? res : -1);
    }

    // 연결 가능한 간선 체크
    static void check() {
        int nx, ny;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) continue;
                
                // 한 쪽 방향씩 탐색하며 섬 찾기
                for (int k = 0; k < 4; k++) {
                    nx = i;
                    ny = j;
                    int d = 0; // 거리
                    while (true) {
                        nx += moves[k][0];
                        ny += moves[k][1];

                        if (!isPossible(nx, ny)) break; // 경로 밖
                        if(board[nx][ny] == 0) { // 바다면 거리 + 1
                            d++;
                            continue;
                        }

                        if (d == 1) break; // 거리가 1이면 불가능

                        edges.add(new int[] {board[i][j], board[nx][ny], d});
                        break;
                    }
                }
            }
        }
    }
    
    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return false;
        if (a < b) p[b] = a;
        else p[a] = b;

        return true;
    }

    static int find(int n) {
        if (p[n] == n) return n;
        return p[n] = find(p[n]);
    } 

    static boolean isPossible(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < M);
    }

    static void makeSet() {
        p = new int[cnt + 1];
        for (int i = 1; i < cnt + 1; i++) p[i] = i;
    }
}
