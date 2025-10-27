package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_34546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long std = 1_000_000_001;
        long sum = 0;

        st = new StringTokenizer(br.readLine());
        int n;
        for (int i = 0; i < N; i++) {
            n = Integer.parseInt(st.nextToken());
            std = Math.min(std, n);
            sum += n;
        }

        System.out.print(sum - (std * N));
    }
}
