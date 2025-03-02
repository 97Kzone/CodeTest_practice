package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_31803 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        long res = 1;
        for (int i = N; i > 0; i -= 2) {
            if (i == 1) continue;
            res *= (i % 2 == 1 ? i : i - 1);
        }
        System.out.print(res);
    }
}
