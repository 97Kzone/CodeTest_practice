package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2_27967 {

    static int N;
    static char[] words;
    static String s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        words = new char[N];

        words = br.readLine().toCharArray();
        s = "";
        check(0);
        System.out.print(s);
    }
    
    static void check(int idx) {
        if (idx == N) {
            if (!isPossible()) {
                return;
            }
        }

        if (words[idx] == 'G') {
            words[idx] = '(';
            check(idx + 1);
            words[idx] = ')';
            check(idx + 1);
        }

        check(idx + 1);
    }
    
    static boolean isPossible() {
        int res = 0;
        for (char word : words) {
            res += word == '(' ? 1 : -1;
        }

        if (res == 0) {
            for (char word : words) {
                s += word;
            }
            System.out.print(s);
            System.exit(0);
        }

        return false;
    }
}
