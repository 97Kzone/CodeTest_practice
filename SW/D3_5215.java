import java.util.*;
 
public class D3_5215 {
    static int N, L;
    static int[][] food; 
    static int res;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int T = sc.nextInt();
        for (int t=1; t<=T; t++) {
            N = sc.nextInt();
            L = sc.nextInt();
 
            food = new int[N][2];
 
            for (int i=0; i<N; i++) {
                food[i][0] = sc.nextInt();
                food[i][1] = sc.nextInt();
            }
             
            res = 0;
            DFS(0, 0, 0);
 
            System.out.printf("#%d %d\n", t, res);
        }
    }
 
    public static void DFS(int i, int score, int now) {
        if (now >= L) return;
        res = Math.max(res, score);
        if (i == N) return;
 
        DFS(i+1, score, now);
        DFS(i+1, score+food[i][0], now+food[i][1]);
 
    }
}