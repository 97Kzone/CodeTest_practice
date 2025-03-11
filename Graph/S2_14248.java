package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_14248 {

    static int N;
    static int[] nums;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        visit = new boolean[N];
        Queue<Integer> q = new ArrayDeque<>();
        
        int idx = Integer.parseInt(br.readLine());
        q.offer(idx-1);
        visit[idx-1] = true;

        int now, nxt1, nxt2;
        while(!q.isEmpty()) {
            now = q.poll();

            nxt1 = now + nums[now];
            nxt2 = now - nums[now];

            if (nxt1 < N) {
                if (visit[nxt1]) continue;
                q.offer(nxt1);
                visit[nxt1] = true;
            }

            if (nxt2 >= 0) {
                if (visit[nxt2]) continue;
                q.offer(nxt2);
                visit[nxt2] = true;
            }
        }

        int res = 0;
        for (boolean flag : visit) {
            if (flag) res++;
        }

        System.out.print(res);

    }
}
