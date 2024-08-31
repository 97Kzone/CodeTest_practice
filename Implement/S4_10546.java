package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class S4_10546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        String s;
        for (int i = 0; i < N; i++) {
            s = br.readLine();
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }

        for (int i = 0; i < N - 1; i++) {
            s = br.readLine();
            if (map.get(s) == 1) {
                map.remove(s);
            } else {
                map.put(s, map.get(s) - 1);
            }
        }

        for (String key : map.keySet()) {
            System.out.print(key);
        }
    }
}
