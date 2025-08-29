package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class S4_14402 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int q = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        String name, cmd;
        int res = 0;
        int cnt;
        while(q-- > 0) {
            st = new StringTokenizer(br.readLine());

            name = st.nextToken();
            cmd = st.nextToken();

            if ("+".equals(cmd)) {
                map.put(name, map.getOrDefault(name, 0) + 1);
            } else {
                cnt = map.getOrDefault(name, 0);
                if (cnt != 0) {
                    map.put(name, map.get(name) - 1);
                } else {
                    res++;
                }
            }
        }
        
        for (int v : map.values()) {
            res += v;
        }

        System.out.print(res);
    }
}
