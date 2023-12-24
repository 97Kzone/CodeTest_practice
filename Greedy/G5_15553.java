package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G5_15553 {

    static int N, K;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()) - 1;

        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        
        int res = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> (o2 - o1));

        for (int i = 1; i < N; i++) {
            pq.offer(nums[i] - nums[i - 1]);
        }

        while (!pq.isEmpty()) {
            if (K == 0) {
                res += pq.poll();
            } else {
                pq.poll();
                res += 1;
                K--;
            }
        }

        System.out.print(res);
    }
}
