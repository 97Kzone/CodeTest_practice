package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class S5_31908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Map<String, List<String>> map = new HashMap<>();

        String name, ring;
        List<String> list;
        int res = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            name = st.nextToken();
            ring = st.nextToken();

            if ("-".equals(ring)) {
                continue;
            }

            if (map.containsKey(ring)) {
                map.get(ring).add(name);
            } else {
                list = new ArrayList<>();
                list.add(name);
                map.put(ring, list);
            }
        }

        for (String key : map.keySet()) {
            if (map.get(key).size() == 2) {
                res++;
            }
        }

        sb.append(res + "\n");
        for (String key : map.keySet()) {
            list = map.get(key);

            if (list.size() < 2)
                continue;

            if (list.size() == 2) {
                sb.append(list.get(0) + " " + list.get(1)).append("\n");
                continue;
            }

            // if (list.size() % 2 == 0) {
            //     for (int i = 0; i < list.size(); i += 2) {
            //         sb.append(list.get(i) + " " + list.get(i + 1)).append("\n");
            //         continue;
            //     }
            // } 
        }

        System.out.print(sb);
    }
}
