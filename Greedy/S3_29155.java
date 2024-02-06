package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S3_29155 {
    
    static int N;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[6];

        st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer>[] pq = new PriorityQueue[6];
        for (int i = 1; i <= 5; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            pq[i] = new PriorityQueue<>();
        }

        int a, b;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            pq[a].offer(b);
        }

        int res = 0;
        int std, tmp;
        int cnt = 0;
        for (int i = 1; i <= 5; i++) {
            if (nums[i] == 0) {
                cnt++;
                continue;
            }

            std = pq[i].poll();
            res += std;

            for (int j = 1; j < nums[i]; j++) {
                tmp = pq[i].poll();
                res += tmp + tmp - std;
                std = tmp;
            }
        }
        
        System.out.print(res + (60 * (4 - cnt)));
    }
}
