package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class S1_33939 {

    static int N, M;
    static Map<Integer, List<Integer>> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        boolean[][] visit = new boolean[N+1][N+1];

        int s, e;
        List<Integer> tmp;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            
            visit[s][e] = true;
            if(!map.containsKey(e)) {
                tmp = new ArrayList<>();
                tmp.add(s);
                map.put(e, tmp);
            } else {
                map.get(e).add(s);
            }

            visit[e][s] = true;
        }

        int result = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            for (int j = 0; j < list.size() - 1; j++) {
                for (int k = j + 1; k < list.size(); k++) {
                    if (!visit[list.get(j)][list.get(k)]) {
                        result++;
                    }
                }
            }
        }
        
        System.out.print(result);
    }
}
