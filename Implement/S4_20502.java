package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S4_20502 {

    static int N, M;
    static int[] nums;
    static Map<Integer, List<Integer>> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        map = new HashMap<>();
        int cnt, v;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                v = Integer.parseInt(st.nextToken());

                if (map.containsKey(v)) {
                    map.get(v).add(i);
                } else {
                   List<Integer> list = new ArrayList<>();
                   list.add(i);
                   map.put(v, list); 
                }
            }
        }

        int Q = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[1] - o2[1]));
        for (int i = 0; i < Q; i++) {
            v = Integer.parseInt(br.readLine());

            pq.clear();
            if (map.containsKey(v)) {
                for (int n : map.get(v)) {
                    pq.offer(new int[] {n, nums[n]});
                }
    
                while(!pq.isEmpty()) {
                    bw.write(pq.poll()[0] + " ");
                }
            } else {
                bw.write("-1");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
