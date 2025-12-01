package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S5_22614 {

    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        
        int t, s, d, cnt;
        boolean[] nums;
        int[] now;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[0] - o2[0]));
        while(true) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) break;

            // init
            pq.clear();
            nums = new boolean[N+1];
            nums[1] = true;
            cnt = 1;

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                
                t = Integer.parseInt(st.nextToken());
                s = Integer.parseInt(st.nextToken());
                d = Integer.parseInt(st.nextToken());

                pq.offer(new int[] {t, s, d});
            }

            while(!pq.isEmpty()) {
                now = pq.poll();                

                if(!nums[now[1]]) continue;
                if(nums[now[2]]) continue;
                
                nums[now[2]] = true;
                cnt++;
            }

            bw.write(cnt + "\n");
        } 

        bw.flush();
        bw.close();
        
    }
}
