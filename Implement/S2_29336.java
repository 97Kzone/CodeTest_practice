package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2_29336 {

    static int N, M;
    static long[] A;
    static long[] T;
    static long[] Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        A = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }
        
        T = new long[M];
        Q = new long[M];
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Long.parseLong(st.nextToken());
            Q[i] = Long.parseLong(st.nextToken());
        }
        
        Arrays.sort(A);
        for (int i = 0; i < N / 2; i++) {
            long temp = A[i];
            A[i] = A[N - 1 - i];
            A[N - 1 - i] = temp;
        }
        
        int i, j;
        long sum = 0;
        
        for (i = 0, j = 0; i < M; i++) {
            long t = T[i];
            long q = Q[i];
            
            while (sum < q && j < N) {
                sum += A[j] + t;
                j++;
            }
        }
        
        for (int k = j; k < N; k++) {
            sum += A[k] + T[T.length - 1];
        }
        
        long result = sum < Q[Q.length - 1] ? -1 : sum;
        System.out.print(result);
    }
}
