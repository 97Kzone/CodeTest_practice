package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_25178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        String s1, s2;
        
        s1 = br.readLine();
        s2 = br.readLine();
        int[] cnt = new int[26];

        for (int i = 0; i < N; i++) {
            cnt[s1.charAt(i) - 'a']++;
            cnt[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0) {
                System.out.print("NO");
                return;
            }
        }

        if (s1.charAt(0) != s2.charAt(0) || s1.charAt(N - 1) != s2.charAt(N - 1)) {
            System.out.print("NO");
            return;
        }
        
        s1 = s1.replaceAll("[aeiou]", "");
        s2 = s2.replaceAll("[aeiou]", "");

        System.out.print(s1.equals(s2) ? "YES" : "NO");

    }
}
