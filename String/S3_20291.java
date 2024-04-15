package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class S3_20291 {

    static HashMap<String, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        map = new HashMap<>();

        String[] s;
        for (int i = 0; i < N; i++) {
            s = br.readLine().split("\\.");

            if (map.containsKey(s[1])) map.put(s[1], map.get(s[1]) + 1);
            else map.put(s[1], 1);
        }

        ArrayList<String> list = new ArrayList<>();
        for (String k : map.keySet()) list.add(k);

        Collections.sort(list);

        for (String k : list) sb.append(k + " " + map.get(k) + "\n");

        System.out.print(sb);
    }
}