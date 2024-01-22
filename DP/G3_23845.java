package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G3_23845 {

    static int N;
    static Integer[] nums; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new Integer[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums, Collections.reverseOrder());

        PriorityQueue<Integer>[] pq = new PriorityQueue[100002];
        for (int i = 0; i < 100002; i++) {
            pq[i] = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        }

        int tmp;
        for (int i = 0; i < N; i++) {
            if (pq[nums[i] + 1].isEmpty()) pq[nums[i]].add(nums[i]);
            else {
                tmp = pq[nums[i] + 1].poll();
                pq[nums[i]].add(tmp);
            }
        }

        long res = 0;
        long v;
        for (int i = 1; i < 100002; i++) {
            while (!pq[i].isEmpty()) {
                v = pq[i].poll();
                res += v * (v - i + 1);
            }
        }

        System.out.print(res);
    }
}
