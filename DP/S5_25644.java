package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_25644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int res = 0;
        int min = 1000000001;

        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            res = Math.max(res, tmp - min);
            min = Math.min(min, tmp);
        }
        System.out.println(res);
    }
}
