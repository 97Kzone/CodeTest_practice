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

public class S3_16165 {

    static int N, M;
    static Map<String, List<String>> map1;
    static Map<String, String> map2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map1 = new HashMap<>();
        map2 = new HashMap<>();

        String team, name;
        int cnt;
        for (int i = 0; i < N; i++) {
            team = br.readLine();
            cnt = Integer.parseInt(br.readLine());
            map1.put(team, new ArrayList<>());
            for (int j = 0; j < cnt; j++) {
                name = br.readLine();
                map1.get(team).add(name);
                map2.put(name, team);
            }
        }

        for (String key : map1.keySet()) {
            Collections.sort(map1.get(key));
        }

        for (int i = 0; i < M; i++) {
            name = br.readLine();
            cnt = Integer.parseInt(br.readLine());

            if (cnt == 1) {
                sb.append(map2.get(name) + "\n");
            } else {
                for (String n : map1.get(name)) {
                    sb.append(n + "\n");
                }
            }
        }

        System.out.print(sb.toString());
    }
}
