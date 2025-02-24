package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S4_30089 {
    static String word;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            word = br.readLine();

            int idx = 0;
            while (idx < word.length()) {
                if (check(idx)) break;
                idx++;
            }

            sb.append(word);
            while(idx > 0) {
                idx--;
                sb.append(word.charAt(idx));
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    } 

    static boolean check(int idx) {
        int j = word.length();

        while (idx < word.length()) {
            if (word.charAt(idx++) != word.charAt(--j)) {
                return false;
            }
        }

        return true;
    }
}
