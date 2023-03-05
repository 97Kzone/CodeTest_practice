import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_4014 {
    static int N, X, res;
    static int[] h;
    static int[][] board;
    static boolean[] v1, v2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());

            board = new int[N][N];
            h = new int[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            res = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    h[j] = board[i][j];
                }
                if (check()) res++;
            }

            for (int j = 0; j < N; j++) {
                for (int i = 0; i < N; i++) {
                    h[i] = board[i][j];
                }
                if (check()) res++;
            }

            sb.append("#" + t + " ").append(res + "\n");
        }
        System.out.print(sb.toString());
    }

    // 검사
    static boolean check() {
        for (int i = 0; i < N-1; i++){
            if (Math.abs(h[i] - h[i+1]) > 1) return false;
        }

        v1 = new boolean[N]; // 오르막
        v2 = new boolean[N]; // 내리막

        for (int i = 0; i < N-1; i++) {  
            if (h[i] + 1 == h[i+1]) { // 오르막
                if (isPossible(i-X+1, i)) {
                    for (int k = i-X+1; k <= i; k++) v1[k] = true;
                } else return false;
            } else if (h[i] - 1 == h[i+1]) { // 내리막
                if (isPossible(i+1, i+X)) {
                    for (int k = i+1; k <= i+X; k++) v2[k] = true;
                } else return false;
            }

            for (int j = 0; j < N; j++) {
                if (v1[j] && v2[j]) return false;
            }
        }
        
        return true;
    }

    // 경사로 설치가능?
    static boolean isPossible(int s, int e) {
        if (s < 0 || e >= N) return false;
        for (int i = s; i < e; i++) {
            if(h[i] != h[i+1]) return false;
        }
        return true;
    }
}
