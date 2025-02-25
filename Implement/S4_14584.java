package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S4_14584 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char[] words = br.readLine().toCharArray();
        int N = Integer.parseInt(br.readLine());

        String[] std = new String[N];
        for (int i = 0; i < N; i++) {
            std[i] = br.readLine();
        }

        String s;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < words.length; j++) {
                words[j] = (char) (((words[j] - 'a' + 1) % 26) + 'a');
            }

            s = String.valueOf(words);
            for (int j = 0; j < N; j++) {
                if (!s.contains(std[j])) continue;
                System.out.print(s);
                return;
            }
        }
    }
}
