package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_1500 {

    static int S, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int div = S / K;
        int mod = S % K;

        long res = 1;
        for (int i = 0; i < mod; i++) res *= (div + 1);
        for (int i = 0; i < K - mod; i++) res *= div;
        
        System.out.print(res);
    }
}
