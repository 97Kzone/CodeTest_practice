package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class S5_32943 {

    static int X, C, K;
    static Map<Integer, Integer> map;
    static Map<Integer, Integer> nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new HashMap<>();

        int T, S, N;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[0] - o2[0]));
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            T = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            pq.offer(new int[] {T, S, N});
        }

        int[] now;
        int key, num;
        nums = new HashMap<>();
        while(!pq.isEmpty()) {
            now = pq.poll();
            key = now[1];
            num = now[2];

            if (map.containsKey(key)) continue;
            
            map.put(key, num);
            if (nums.containsKey(num)) {
                map.remove(nums.get(num));
                nums.remove(num);
            }
            nums.put(num, key);
        }

        List<Integer> list = new ArrayList<>();
        for (int keys : nums.keySet()) {
            list.add(keys);
        }

        Collections.sort(list);
        for (int k : list) {
            bw.write(k + " " + nums.get(k));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
