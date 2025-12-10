package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S3_32284 {

    static int N, M, A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        // 1. A 행 전까진 전부 S
        for (int i = 0; i < A; i++) {
            bw.write("S".repeat(M));
            bw.write("\n");
        }

        // 2. A 행에서는 B열 전까니 E, B열 이후 W
        for (int i = 0; i < B; i++) {
            bw.write("E");
        }

        for (int i = B; i < M; i++) {
            bw.write("W");
        }

        bw.write("\n");

        // 3. A 행 이후는 N
        for (int i = A+1; i < N; i++) {
            bw.write("N".repeat(M));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        
    }
}
