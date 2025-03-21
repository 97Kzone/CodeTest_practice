package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class S3_9375 {

    static int N;
    static Map<String, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        
        String name, type;
        long res;
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            
            map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                name = st.nextToken();
                type = st.nextToken();
    
                map.put(type, map.getOrDefault(type, 0) + 1);
            }

            res = 1;
            for (int v: map.values()) {
                res *= v + 1;
            }

            sb.append(res - 1 + "\n");
        }

        System.out.print(sb.toString());
    }
}
