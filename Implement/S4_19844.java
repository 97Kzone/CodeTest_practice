package Implement;

import java.io.*;

public class S4_19844 {

    static String[] std = {"c'", "j'", "n'", "m'", "t'", "s'", "l'", "d'", "qu'"};
    static char[] std2 = {'a', 'e', 'i', 'o', 'u', 'h'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] words = br.readLine().replace(" ", "-").split("-");

        int cnt = words.length;

        for (String w : words) {
            if (w.length() >= 3) {
                String p2 = w.substring(0, 2);
                String p3 = w.substring(0, 3);

                if (check(p2) && check2(w.charAt(2))) {
                    cnt++;
                } else if (check(p3) && w.length() >= 4 && check2(w.charAt(3))) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    static boolean check(String s) {
        for (String p : std) {
            if (p.equals(s)) return true;
        }
        return false;
    }

    static boolean check2(char c) {
        for (char v : std2) {
            if (v == c) return true;
        }
        return false;
    }
}
