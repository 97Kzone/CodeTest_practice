package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class S3_2607 {
    static int N;
    static Map<Character, Integer> map, map2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new HashMap<>();
        N = Integer.parseInt(br.readLine());

        // 초기 세팅
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int res = 0;
        for (int i = 1; i < N; i++) {
            s = br.readLine();

            if (check(s))
                res++;
        }

        System.out.println(res);
    }
    
    static boolean check(String s) {
        boolean flag = true;
        map2 = new HashMap<>(map);

        for (int i = 0; i < s.length(); i++) {
            if (map2.getOrDefault(s.charAt(i), 0) == 0) {
                if (!flag)
                    return false;
                else
                    flag = false;
            } else {
                map2.put(s.charAt(i), map2.get(s.charAt(i)) - 1);
            }
        }

        return true;
    }
}
