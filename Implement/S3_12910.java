package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class S3_12910 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());

        int n;
        for (int i = 0; i < N; i++) {
            n = Integer.parseInt(st.nextToken());

            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }

        long res = 0;
        int std = 1, cnt = 1;
        while (std <= N) {
            if (map.containsKey(std)) {
                cnt *= map.get(std);
            } else break;

            res += cnt;
            std++;
        }
        
        System.out.print(res);
    }
}
