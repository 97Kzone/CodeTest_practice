package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_11663 {

    static int N, M;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        int l, r, a, b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());

            a = check1(l);
            b = check2(r);

            sb.append(b - a).append("\n");
        }

        System.out.print(sb.toString());
    }

    static int check1(int v) {
        int l = 0;
        int r = N;

        int m;
        while(l < r) {
            m = (l + r) / 2;
            if (nums[m] < v) l = m + 1;
            else r = m;
        }

        return l;
    }

    static int check2(int v) {
        int l = 0;
        int r = N;
        
        int m;
        while(l < r) {
            m = (l + r) / 2;
            if (nums[m] <= v) l = m + 1;
            else r = m;
        }

        return l;
    }
}
