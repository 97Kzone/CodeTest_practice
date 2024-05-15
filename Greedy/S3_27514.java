package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class S3_27514 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        long v;
        long res = 0;
        for (int i = 0; i < N; i++) {
            v = Long.parseLong(st.nextToken());
            map.put(v, map.getOrDefault(v, 0) + 1);

            res = Math.max(res, v);
        }

        int cnt;
        for (int i = 0; i <= 62; i++) {
            v = (long) Math.pow(2, i);
            cnt = map.getOrDefault(v, 0);
            if (cnt < 2) continue;

            v = (long) Math.pow(2, i + 1);
            map.put(v, map.getOrDefault(v, 0) + cnt / 2);
            res = Math.max(v, res);
        }

        System.out.print(res);
    }
}
