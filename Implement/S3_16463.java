package Implement;

import java.io.*;

public class S3_16463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        
        int res = 0;
        int std = 13;

        for (int i = 2019; i < N + 1; i++) {
            for (int j = 0; j < 12; j++) {
                if (std % 7 == 4) res++;
                std += days[j];

                if (j == 1) {
                    if ((i % 400 == 0 || (i % 4 == 0 && i % 100 != 0))) std++;
                }
            }
        }
        
        System.out.print(res);
    }
}
