package BruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class S4_4096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s;
        while(true) {
            s = br.readLine();
            if ("0".equals(s)) break;

            bw.write(check(s) + "");
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    static int check(String s) {
        int len = s.length();
        int n = Integer.parseInt(s);
        int cnt = 0;

        while(true) {
            if (isPossible(n, len)) {
                return cnt;
            }

            n++;
            cnt++;
        }
    }

    static boolean isPossible(int n, int len) {
        char[] nums = new char[len];
        char[] std = String.valueOf(n).toCharArray();
        int v = len - std.length;
        
        Arrays.fill(nums, 0, v, '0');
        System.arraycopy(std, 0, nums, v, std.length);

        int l = 0, r = len - 1;
        while(l < r) {
            if (nums[l++] != nums[r--]) return false;
        }

        return true;
    }
}
