package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S4_26123 {

    static int N, D;
    static Map<Integer, Integer> map;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new HashMap<>();
        
        st = new StringTokenizer(br.readLine());
        int n;
        int std = 0;
        for (int i = 0; i < N; i++) {
            n = Integer.parseInt(st.nextToken());
            std = Math.max(std, n);
            map.put(n, map.getOrDefault(n, 0) + 1);            
        }

        long res = 0;
        int v;
        for (int i = 0; i < D; i++) {
            if (std == 0) break;
            v = map.get(std);
            res += v;
            std--;
            map.put(std, map.getOrDefault(std, 0) + v);
        }

        System.out.print(res);
    }
}
