package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class S3_26267 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Long> map = new HashMap<>();

        int X, T, C;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            X = Integer.parseInt(st.nextToken());
            T = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            map.put(X - T, map.getOrDefault(X - T, 0L) + C);
        }

        long res = 0;
        for (int k : map.keySet()) {
            res = Math.max(res, map.get(k));
        }
        
        System.out.print(res);
    }
}
