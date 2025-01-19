package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int[] nums;
        int N;
        long res;
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            res = 0;
            for (int i = 0; i < N - 1; i++) {
                for (int j = i+1; j < N; j++) {
                    res += gcd(nums[i], nums[j]);
                }
            }
            sb.append(res + "\n");
        }
        System.out.print(sb.toString());
    }

    static long gcd(int n1, int n2) {
        int tmp;
        while (n2 > 0) {
            tmp = n2;
            n2 = n1 % n2;
            n1 = tmp;
        }

        return n1;
    }
}
