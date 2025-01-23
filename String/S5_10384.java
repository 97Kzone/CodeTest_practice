package String;

import java.io.*;

public class S5_10384 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] cnt;
        String s;
        String res = "";
        for (int i = 1; i <= N; i++) {
            cnt = new int[26];
            s = br.readLine().replaceAll("\\s", "").toUpperCase();
            
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) >= 'A' && s.charAt(j) <= 'Z') cnt[s.charAt(j) - 'A']++;
            }

            int std = 3;
            for (int j = 0; j < 26; j++) {
                std = Math.min(std, cnt[j]);
            }

            if (std == 0) {
                res = "Not a pangram";
            } else if (std == 1) {
                res = "Pangram!";
            } else if (std == 2) {
                res = "Double pangram!!";
            } else if (std == 3) {
                res = "Triple pangram!!!";
            }

            sb.append("Case " + i + ": " + res).append("\n");
        }
        System.out.print(sb.toString());
    }
}