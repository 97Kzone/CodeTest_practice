package SW_Bclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B2948 {
    static Map<String, Integer> map;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new HashMap<>();

            String[] words = br.readLine().split(" ");
            for (String word : words) {
                map.put(word, 1);
            }
            
            words = br.readLine().split(" ");
            int res = 0;
            for (String word : words) {
                int v = map.getOrDefault(word, 0);
                res += v;
            }

            sb.append("#" + t + " ").append(res + "\n");
        }
        System.out.print(sb.toString());
    }
}
