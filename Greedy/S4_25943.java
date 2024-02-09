package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_25943 {

    static int N;
    static int[] nums = { 100, 50, 20, 10, 5, 2, 1 };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        int a = 0, b = 0;
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            if (a == b) {
                a += Integer.parseInt(st.nextToken());
            } else {
                if (a > b) {
                    b += Integer.parseInt(st.nextToken());
                } else {
                    a += Integer.parseInt(st.nextToken());
                }
            }
        }

        int std = Math.abs(a - b);
        int res = 0;
        for (int i = 0; i < 7; i++) {
            while (true) {
                if (std < nums[i]) break;
                
                std -= nums[i];
                res++;
            }
        }
        System.out.print(res);
    }
}
