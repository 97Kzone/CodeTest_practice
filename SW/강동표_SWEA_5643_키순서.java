import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import java.util.Arrays;


// 플로이드 와샬 풀이
public class D4_5643 {
    static int N, M, res, std;
    static int[][] dp1, dp2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        std = 987654321;
        
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
    
            dp1 = new int[N][N];
            dp2 = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(dp1[i], std);
                Arrays.fill(dp2[i], std);
            }
            int a, b;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
    
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
    
                dp1[a-1][b-1] = 1;
                dp2[b-1][a-1] = 1;
            }
    
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        dp1[j][k] = Math.min(dp1[j][k], dp1[j][i] + dp1[i][k]);
                        dp2[j][k] = Math.min(dp2[j][k], dp2[j][i] + dp2[i][k]);
                    }
                }
            }
    
            int cnt;
            res = 0;
            for (int i = 0; i < N; i++) {
                cnt = 0;
                for (int j = 0; j < N; j++) {
                    if (i == j) continue;
    
                    cnt += dp1[i][j] == std ? 0 : 1;
                    cnt += dp2[i][j] == std ? 0 : 1;
                }
                if (cnt == N-1) res++;
            }
            System.out.println("#" + t + " " + res);
        }
    }
}


// BFS 풀이
// public class D4_5643 {
//     static int N, M, res;
//     static boolean[][] board;
//     static boolean[] check;

//     static void sol() throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st;

//         int T = Integer.parseInt(br.readLine());
//         for (int t = 1; t <= T; t++) {
//             N = Integer.parseInt(br.readLine());
//             M = Integer.parseInt(br.readLine());

//             board = new boolean[N+1][N+1];
//             res = 0;

//             int s, e;
//             for (int i = 0; i < M; i++) {
//                 st = new StringTokenizer(br.readLine());
//                 s = Integer.parseInt(st.nextToken());
//                 e = Integer.parseInt(st.nextToken());

//                 board[s][e] = true;
//             }

//             for (int i = 1; i < N+1; i++) {
//                 check = new boolean[N+1];
//                 if (bfs(i)) res += 1;
//             }

//             System.out.printf("#%d %d\n", t, res);
//         }
//     }

//     static boolean bfs(int idx) {
//         Queue<int[]> q = new LinkedList<>();
//         q.offer(new int[] {idx, 0});
//         check[idx] = true;

//         int cnt = 0;
//         while(!q.isEmpty()) {
//             int[] tmp = q.poll();
//             int now = tmp[0];
//             int v = tmp[1];

//             cnt += 1;

//             for (int i = 1; i < N+1; i++) {
//                 if (check[i]) continue; // 가지치기

//                 if (v >= 0 && board[now][i]) {
//                     q.offer(new int[] {i, 1});
//                     check[i] = true;
//                 }

//                 if (v <= 0 && board[i][now]) {
//                     q.offer(new int[] {i, -1});
//                     check[i] = true;
//                 }
//             }
//         }

//         return cnt == N;
//     }
//     public static void main(String[] args) throws IOException {
//         sol();
//     }
// }
