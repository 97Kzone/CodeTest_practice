package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_5671 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String s;
        int N, M;
        while ((s = br.readLine()) != null) {
            st = new StringTokenizer(s);

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            int cnt = 0;
            for (int i = N; i <= M; i++) {
                if (check(i))
                    cnt++;
            }
            sb.append(cnt + "\n");
        }
        System.out.print(sb);
    }

    static boolean check(int n) {
        int[] nums = new int[10];
        while (n != 0) {
            nums[n % 10]++;

            if (nums[n % 10] == 2) return false;
            n /= 10;
        }
        
        return true;
    }
}
