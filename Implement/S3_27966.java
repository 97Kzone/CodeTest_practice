package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_27966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long N = Long.parseLong(br.readLine());
        sb.append((N-1) + (N-2) * (N - 1)).append("\n");

        for (int i = 2; i <= N; i++) {
            sb.append("1 " + i).append("\n");
        }
        
        System.out.print(sb.toString());
        
    }
}
