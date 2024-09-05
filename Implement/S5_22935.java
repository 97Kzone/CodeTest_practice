package Implement;

import java.io.*;

public class S5_22935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N;
        int T = Integer.parseInt(br.readLine());
        int[] nums = { 2, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3 };

        int mod;
        String bin;
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            mod = N % 28;
            bin = Integer.toBinaryString(nums[mod]);

            while (bin.length() < 4) {
                bin = "0" + bin;
            }
            
            for(char c : bin.toCharArray()) {
                if (c == '0') {
                    sb.append("V");
                } else {
                    sb.append("딸기");
                }
            }
            sb.append("\n");
        }   

        System.out.print(sb);
    }
}
