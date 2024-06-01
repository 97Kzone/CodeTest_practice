package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S4_11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        List<String> words = new ArrayList<>();
        String s = br.readLine();

        words.add(s);
        for (int i = 1; i < s.length(); i++) {
            words.add(s.substring(i, s.length()));
        }

        Collections.sort(words);
        for (String word : words) {
            sb.append(word + "\n");
        }

        System.out.print(sb);
    }
}
