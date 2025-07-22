package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S5_24091 {

    static int N, K, cnt;
    static int[] nums;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        cnt = 0;
        qsort(0, N-1);

        if (sb.length() == 0) {
            sb.append("-1");
        }

        System.out.print(sb.toString());
    }

    static void qsort(int l, int r) {
        if (l < r) {
            int v = part(l, r);
            qsort(l, v - 1);
            qsort(v + 1, r);
        }
    }

    static int part(int l, int r) {
        int std = nums[r];
        int idx = l - 1;

        for (int i = l; i < r; i++) {
            if (nums[i] <= std) {
                swap(++idx, i);
            }
        }

        if (idx + 1 != r) {
            swap(idx + 1, r);
        }

        return idx + 1;
    }

    static void swap(int a, int b) {
        if(a != b) {
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
        }

        cnt++;
        if (cnt == K) {
            for (int num : nums) {
                sb.append(num + " ");
            }
        }
    }
}
