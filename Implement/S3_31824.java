package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class S3_31824 {

    static int N, M;
    static Map<String, String> dict;
    static List<String> words;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dict = new HashMap<>();
        words = new ArrayList<>();

        String word, mean;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            word = st.nextToken();
            mean = st.nextToken();

            dict.put(word, mean);
            words.add(word);
        }

        Collections.sort(words);

        String s;
        StringBuilder str;
        for (int i = 0; i < M; i++) {
            s = br.readLine();
            str = new StringBuilder();

            for (int j = 0; j < s.length(); j++) {
                for (String k : words) {
                    if (s.startsWith(k, j)) {
                        str.append(dict.get(k));
                    }
                }
            }

            if (str.length() == 0) sb.append("-1\n");
            else sb.append(str).append("\n");
        }

        System.out.print(sb);
    }
}
