package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_6550 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S;
        String[] words;
        String s1, s2;
        while ((S = br.readLine()) != null) {
            words = S.split(" ");

            s1 = words[0];
            s2 = words[1];

            int idx = 0;

            for (int i = 0; i < s2.length(); i++) {
                if (s1.charAt(idx) == s2.charAt(i)) {
                    idx++;
                }

                if (idx == s1.length())
                    break;
            }

            if (idx == s1.length()) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }

    }
}
