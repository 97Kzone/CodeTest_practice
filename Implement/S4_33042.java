package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class S4_33042 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        String name;
        for (int i = 1; i <= N; i++) {
            name = st.nextToken();

            map.put(name, map.getOrDefault(name, 0) + 1);
            if (map.get(name) == 5) {
                System.out.print(i);
                return;
            }
        }

        System.out.print(0);
    }
}
