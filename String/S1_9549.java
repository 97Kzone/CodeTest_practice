package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_9549 {
    static int[] cpt;
    static int[] origin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        String s1, s2;
        boolean flag;
        for (int t = 0; t < T; t++) {
            s1 = br.readLine();
            s2 = br.readLine();

            flag = false;
            cpt = new int[26];
            origin = new int[26];

            for (int i = 0; i < s2.length(); i++) cpt[s1.charAt(i) - 'a']++;
            for (int i = 0; i < s2.length(); i++) origin[s2.charAt(i) - 'a']++;

            for (int i = s2.length(); i < s1.length(); i++) {
                if (check()) {
                    flag = true;
                    break;
                }

                cpt[s1.charAt(i - s2.length()) - 'a']--;
                cpt[s1.charAt(i) - 'a']++;
            }

            if (check()) flag = true;

            sb.append(flag ? "YES" : "NO").append("\n");
        }
        System.out.print(sb);
    }
    
    static boolean check() {
        for (int i = 0; i < 26; i++) {
            if (cpt[i] != origin[i]) {
                return false;
            }
        }

        return true;
    }
}
