package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_24938 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] num = new long[N];

        st = new StringTokenizer(br.readLine());
        long std = 0;
        for (int i = 0; i < N; i++) {
            num[i] = Long.parseLong(st.nextToken());
            std += num[i];
        }
        std /= N;

        for (int i = 0; i < N; i++) num[i] -= std;            
        
        long res = 0;
        for (int i = 0; i < N - 1; i++) {
            res += Math.abs(num[i]);
            num[i + 1] += num[i];
        }
        
        System.out.print(res);
    }
}
