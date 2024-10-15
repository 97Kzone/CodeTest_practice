package Implement;

import java.util.*;
import java.io.*;

public class S3_32373 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < k; i++) {
            List<Integer> mods = new ArrayList<>();
            int j = i;
            while (j < N) {
                mods.add(nums[j]);
                j += k;
            }

            Collections.sort(mods);
            j = i;
            int idx = 0;
            while (j < N) {
                nums[j] = mods.get(idx);
                j += k;
                idx++;
            }
        }

        boolean sorted = true;
        for (int i = 0; i < N; i++) {
            if (nums[i] != i) {
                sorted = false;
                break;
            }
        }

        System.out.print(sorted ? "Yes" : "No");
    }
}
