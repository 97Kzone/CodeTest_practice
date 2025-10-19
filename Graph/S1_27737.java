package Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_27737 {
    static int N, M, K;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        arr = new int[N + 1][N + 1];
        visit = new boolean[N + 1][N + 1];
        
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (!visit[i][j] && arr[i][j] == 0) {
                    if (cnt >= M) {
                        bw.write("IMPOSSIBLE\n");
                        bw.flush();
                        bw.close();
                        return;
                    }
                    cnt++;
                    check(i, j);
                }
            }
        }
        
        if (cnt == 0) {
            bw.write("IMPOSSIBLE\n");
        } else {
            bw.write("POSSIBLE\n");
            bw.write((M - cnt) + "\n");
        }
        
        bw.flush();
        bw.close();
    }
     
    static void check(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visit[x][y] = true;
        
        int size = 1;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if (!isPossible(nx, ny)) continue;
                if (visit[nx][ny] || arr[nx][ny] == 1) continue;
                if (size >= K) continue;
                
                visit[nx][ny] = true;
                q.offer(new int[]{nx, ny});
                size++;
            }
        }
    }

    static boolean isPossible(int x, int y) {
        return x >= 1 && y >= 1 && x <= N && y <= N;
    }
}