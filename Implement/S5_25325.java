package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Map.Entry;

public class S5_25325 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            map.put(st.nextToken(), 0);
        }

        String name;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                name = st.nextToken();
                map.put(name, map.get(name) + 1);
            }
        }

        List<Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((o1, o2) -> {
            int v = o2.getValue().compareTo(o1.getValue());

            if (v == 0) return o1.getKey().compareTo(o2.getKey());
            return v;
        });

        for (Map.Entry<String, Integer> std : list) {
            sb.append(std.getKey() + " " + std.getValue() + "\n");
        }

        System.out.print(sb);
    }
}
