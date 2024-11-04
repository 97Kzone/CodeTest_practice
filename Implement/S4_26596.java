package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class S4_26596 {

    static int N;
    static Map<String, Double> map;
    static Set<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new HashMap<>();

        String key;
        Double num;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            key = st.nextToken();
            num = Double.parseDouble(st.nextToken());

            if (map.containsKey(key)) {
                map.put(key, map.get(key) + num);
            } else {
                map.put(key, num);
            }
        }
        
        String res = "Not Delicious...";
        Double std;
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            std = Math.floor(entry.getValue() * 1.618);

            for (Map.Entry<String, Double> tmp : map.entrySet()) {
                if (entry.getKey().equals(tmp.getKey()))
                    continue;
                
                if (std == Math.floor(tmp.getValue())) {
                    System.out.print("Delicious!");
                    return;
                }
            }
        }

        System.out.print(res);
    }
}
