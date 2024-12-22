package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class S5_28432 {

    static int N, M;
    static HashSet<String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        String word;
        int std = 0;
        set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            word = br.readLine();
            if ("?".equals(word)) {
                std = i;
            }
            words[i] = word;
            set.add(word);
        }

        M = Integer.parseInt(br.readLine());
        String res = "";
        for (int i = 0; i < M; i++) {
            word = br.readLine();
            if (N == 1) {
                res = word;
                break;
            }

            if (set.contains(word))
                continue;

            if (std == 0) {
                if (words[std + 1].charAt(0) == word.charAt(word.length() - 1)) {
                    res = word;
                    break;
                }
            } else if (std == N - 1) {
                if (words[std - 1].charAt(words[std - 1].length() - 1) == word.charAt(0)) {
                    res = word;
                    break;
                }
            } else {
                if (words[std + 1].charAt(0) == word.charAt(word.length() - 1) &&
                    words[std - 1].charAt(words[std-1].length() - 1) == word.charAt(0)) {
                    res = word;
                    break;
                }
            }

        }
        System.out.print(res);
    }
}
