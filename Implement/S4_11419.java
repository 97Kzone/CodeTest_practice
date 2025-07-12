package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class S4_11419 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> map = new HashMap<>();

        int n;
        for (int i = 0; i < N; i++) {
            n = Integer.parseInt(br.readLine());

            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (int key : map.keySet()) {
            if (map.get(key) % K == 0) continue;

            bw.write(key + "");
            break;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
