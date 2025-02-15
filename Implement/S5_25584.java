package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class S5_25584 {

    static int[] std = {4, 6, 4, 10};
    static Map<String, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        List<String> list = new ArrayList<>();

        String name;
        for (int i = 0; i < N * 4; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 7; j++) {
                name = st.nextToken();

                if ("-".equals(name)) continue;

                if (map.containsKey(name)) {
                    map.put(name, map.get(name) + std[i % 4]);
                } else {
                    map.put(name, std[i % 4]);
                    list.add(name);
                }
            }
        }
        boolean flag = true;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
    
        int tmp;
        for (int i = 0; i < list.size(); i++) {
            tmp = map.get(list.get(i));
            max = Math.max(max, tmp);
            min = Math.min(min, tmp);
        }

        flag = max - min > 12 ? false : true;
        System.out.print(flag ? "Yes" : "No");
    }

}
