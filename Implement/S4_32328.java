package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class S4_32328 {

    static int N;
    static Map<Integer, Integer> map;
    static TreeSet<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        set = new TreeSet<>();

        int score;
        for (int i = 0; i < N; i++) {
            score = Integer.parseInt(br.readLine());

            set.add(score);
            map.put(score, map.getOrDefault(score, 0) + 1);
        }

        set.pollLast();
        set.pollLast();
        score = set.pollLast();

        bw.write(score + " " + map.get(score));
        bw.flush();
        bw.close();
        br.close();
    }
}
