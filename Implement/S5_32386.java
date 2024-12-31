package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class S5_32386 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int n;
        String name = "";
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();

            n = Integer.parseInt(st.nextToken());

            for (int j = 0; j < n; j++) {
                name = st.nextToken();
                map.put(name, map.getOrDefault(name, 0) + 1);
            }
        }

        int cnt = 0;
        for (String key : map.keySet()) {
            if (map.get(key) > cnt) {
                cnt = map.get(key);
                name = key;
            }
        }

        for (String key : map.keySet()) {
            if (map.get(key) == cnt && !name.equals(key)) {
                System.out.print(-1);
                return;
            }
        }
        
        System.out.print(name);
    }
}
