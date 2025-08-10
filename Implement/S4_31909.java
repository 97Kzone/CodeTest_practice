package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_31909 {

    static int N;
    static int[] nums;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[8];

        for (int i = 0; i < 8; i++) {
            nums[i] = i;
        }

        st = new StringTokenizer(br.readLine());

        int cmd, key1, key2, cnt;
        boolean flag;
        StringBuilder sb;
        for (int i = 0; i < N; i++) {
            cmd = Integer.parseInt(st.nextToken());
            sb = new StringBuilder(Integer.toBinaryString(cmd)).reverse();

            cnt = 0;
            flag = true;
            key1 = 0;
            key2 = 0;

            if (Integer.bitCount(cmd) != 2) continue;

            for (int j = 0; j < sb.length(); j++) {
                if (sb.charAt(j) == '1') {
                    if (cnt == 0) key1 = j;
                    else if (cnt == 1) key2 = j;
                    cnt++;
                }
            }

            swap(key1, key2);
        }

        int K = Integer.parseInt(br.readLine());

        int res = 0;
        for (int i = 0; i < 8; i++) {
            if (nums[i] == K) {
                res = i;
            }
        }

        System.out.print(res);
    }

    static void swap(int k1, int k2) {
        int tmp;

        int idx1 = 0;
        int idx2 = 0;
        for (int i = 0; i < 8; i++) {
            if (nums[i] == k1) {
                idx1 = i;
            }
        
            if (nums[i] == k2) {
                idx2 = i;
            }
        }

        tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = tmp;
    }
}
