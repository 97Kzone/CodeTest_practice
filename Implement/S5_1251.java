package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S5_1251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();

        int n = word.length();
        List<String> arr = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                arr.add(check(word, i, j));
            }
        }
        Collections.sort(arr);
        System.out.print(arr.get(0));
    }

    static String check(final String s, final int a, final int b) {
        StringBuilder s1 = new StringBuilder(s.substring(0, a));
        StringBuilder s2 = new StringBuilder(s.substring(a, b));
        StringBuilder s3 = new StringBuilder(s.substring(b));
        StringBuilder sb = new StringBuilder();
        sb.append(s1.reverse()).append(s2.reverse()).append(s3.reverse());
        return sb.toString();
    }
}
