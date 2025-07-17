package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S4_30949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        Set<String> nameSet = new HashSet<>();

        StringTokenizer st;
        String line;
        while (!(line = br.readLine()).equals("------")) {
            st = new StringTokenizer(line);
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            map1.put(name, map1.getOrDefault(name, 0) + (e - s));
            nameSet.add(name);
        }

        while (!(line = br.readLine()).equals("======")) {
            st = new StringTokenizer(line);
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            map2.put(name, map2.getOrDefault(name, 0) + (e - s));
            nameSet.add(name);
        }

        List<String> names = new ArrayList<>(nameSet);
        Collections.sort(names);

        StringBuilder sb = new StringBuilder();
        for (String name : names) {
            int time1 = map1.getOrDefault(name, 0);
            int time2 = map2.getOrDefault(name, 0);
            int diff = time2 - time1;

            if (diff != 0) {
                sb.append(name).append(' ');
                if (diff > 0) sb.append('+');
                sb.append(diff).append('\n');
            }
        }

        if (sb.length() == 0) {
            System.out.println("No differences found.");
        } else {
            System.out.print(sb);
        }
    }
}
