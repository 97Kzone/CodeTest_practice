import java.util.*;

public class D2_1959 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, M, res;
        int[] A, B;
        int T = sc.nextInt();
        for (int t=1; t<=T; t++) {
            N = sc.nextInt();
            M = sc.nextInt();
            
            A = new int[N];
            B = new int[M];
            for (int i=0; i<N; i++) {
                A[i] = sc.nextInt();
            }

            for (int i=0; i<M; i++) {
                B[i] = sc.nextInt();
            }

            int tmp;
            res = 0;
            if (N == M) {
                for (int i=0; i<N; i++) {
                    res += A[i]*B[i];    
                }
            } else if (N > M) {
                for (int i=0; i<N-M+1; i++) {
                    tmp = 0;
                    for (int j=0; j<M; j++) {
                        tmp += A[i+j]*B[j];
                    }
                    res = Math.max(res, tmp);
                }
            } else {
                for (int i=0; i<M-N+1; i++) {
                    tmp = 0;
                    for (int j=0; j<N; j++) {
                        tmp += A[j]*B[i+j];
                    }
                    res = Math.max(res, tmp);
                }
            }
            System.out.printf("#%d %d\n", t, res);
        }
    }
}
