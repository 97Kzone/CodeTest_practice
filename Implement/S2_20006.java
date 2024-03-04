package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class S2_20006 {

    static int P, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        P = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Map<String, Integer> player = new HashMap<>();
        Map<Integer, List<String>> room = new HashMap<>();

        int idx = 0;
        int level;
        String name;
        boolean flag;
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());

            level = Integer.parseInt(st.nextToken());
            name = st.nextToken();

            player.put(name, level);

            flag = false;
            for (List<String> std : room.values()) {
                if (std.size() == M)
                    continue;

                if (Math.abs(player.get(std.get(0)) - level) <= 10) {
                    std.add(name);
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                List<String> tmp = new ArrayList<>();
                tmp.add(name);
                room.put(idx++, tmp);
            }

        }
        
        for (List<String> std : room.values()) {
            sb.append(std.size() == M ? "Started!" + "\n" : "Waiting!" + "\n");

            Collections.sort(std);
            for (String n : std) {
                sb.append(player.get(n) + " " + n + "\n");
            }            
        }
        System.out.print(sb);
    }
}
