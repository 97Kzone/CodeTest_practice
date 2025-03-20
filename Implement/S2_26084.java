package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class S2_26084 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        char[] std = br.readLine().toCharArray();
        for (char c : std) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int N = Integer.parseInt(br.readLine());
        char c;
        for (int i = 0; i < N; i++) {
            c = br.readLine().charAt(0);
            if(map.containsKey(c)) {
                map2.put(c, map2.getOrDefault(c, 0) + 1);
            }
        }

        long res = 1;

        int v;
        for (char key : map.keySet()) {
            v = map.get(key);

            if (!map2.containsKey(key)) {
                res = 0;
                break;
            }

            for (int i = 0; i < v; i++) res *= (map2.get(key) - i);
            for (int i = 0; i < v; i++) res /= (v - i);
        }

        System.out.print(res);
    }
}
