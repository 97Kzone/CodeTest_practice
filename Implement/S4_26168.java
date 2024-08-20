package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class S4_26168 {

    static int N, M;
    static long[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(nums);

        long a, b, c;
        int cnt, cnt2;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            a = Long.parseLong(st.nextToken());
            b = Long.parseLong(st.nextToken());
            cnt = 0;
            if (a == 1) {
                cnt = N - checkLow(b);
            } else if (a == 2) {
                cnt = N - checkUp(2, b);
            } else if (a == 3) {
                c = Long.parseLong(st.nextToken());

                cnt = checkLow(b);
                cnt2 = checkUp(3, c);
                sb.append(cnt2 - cnt + 1).append("\n");
                continue;
            }

            sb.append(cnt).append("\n");
        }
        
        System.out.print(sb);
    }
    
    static int checkLow(long n) {
        int l = 0;
        int r = N;

        int m;
        while (l < r) {
            m = (l + r) / 2;

            if (n <= nums[m]) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }   
    
    static int checkUp(long a, long n) {
        int l = 0;
        int r = N;

        int m;
        while (l < r) {
            m = (l + r) / 2;

            if (n >= nums[m]) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return a == 2 ? l : l -1;
    }
}
