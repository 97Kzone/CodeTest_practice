package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_28256 {

    static char[][] board;
    static boolean[][] visit;
    static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        int N, num;
        Map<Integer, Integer> map;
        for (int t = 0; t < T; t++) {
            board = new char[3][3];
            for (int i = 0; i < 3; i++) {
                board[i] = br.readLine().toCharArray();
            }

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            map = new HashMap<>();

            for (int i = 0; i < N; i++) {
                num = Integer.parseInt(st.nextToken());
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            visit = new boolean[3][3];
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (visit[i][j]) continue;
                    if (board[i][j] == 'O') {
                        list.add(check(i, j));
                    }
                }
            }

            int tmp;
            boolean flag = true;
            for (int v : list) {
                if (!map.containsKey(v)) {
                    bw.write(0 + "\n");
                    flag = false;
                    break;
                } else {
                    tmp = map.get(v);
                    tmp--;

                    if (tmp == 0) {
                        map.remove(v);
                    } else {
                        map.put(v, tmp);
                    }
                }
            }

            if (flag) {
                if (map.size() == 0) {
                    bw.write(1 + "\n");
                } else {
                    bw.write(0 + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
    }

    static int check(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {x, y});

        visit[x][y] = true;
        int[] now;
        int nx, ny;
        int cnt = 1;
        while(!q.isEmpty()) {
            now = q.poll();

            for (int[] move : moves) {
                nx = now[0] + move[0];
                ny = now[1] + move[1];

                if (!isPossible(nx, ny)) continue;
                if (visit[nx][ny]) continue;
                if (board[nx][ny] != 'O') continue;

                visit[nx][ny] = true;
                q.offer(new int[] {nx, ny});
                cnt++;
            }
        }

        return cnt;
    }

    static boolean isPossible(int x, int y) {
        return (0 <= x && x < 3) && (0 <= y && y < 3);
    }
}
