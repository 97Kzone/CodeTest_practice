package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G5_20311 {

    static int N, K;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int idx = 0, M = 0;
        nums = new int[K + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o2[1] - o1[1]));

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= K; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            pq.offer(new int[] { i, nums[i] });
            if (M < nums[i]) {
                M = nums[i];
                idx = i;
            }
        }
        
        int res = -1;
        if (nums[idx] > (N + 1) / 2) {
            System.out.print(res);
            return;
        }
        
        int[] now, nxt;
        while (!pq.isEmpty()) {
            now = pq.poll();

            if (pq.isEmpty()) {
                sb.append(now[0]);
                break;
            }
            
            nxt = pq.poll();

            sb.append(now[0] + " " + nxt[0] + " ");
            
            if (now[1] > 1) {
                pq.offer(new int[] { now[0], now[1] - 1 });
            }

            if (nxt[1] > 1) {
                pq.offer(new int[] { nxt[0], nxt[1] - 1 });
            }
        }
        
        System.out.print(sb.toString());
    }
}
