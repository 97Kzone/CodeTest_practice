package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_10451 {

    static int N;
    static int[] nums;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        int cnt;
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            
            nums = new int[N+1];
            visit = new boolean[N+1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            cnt = 0;
            for (int i = 1; i <= N; i++) {
                if(visit[i]) continue;

                check(i);
                cnt++;
            }

            sb.append(cnt + "\n");
        }
        System.out.print(sb.toString());
    }

    static void check(int n) {
        if (visit[n]) return;
        visit[n] = true;
        check(nums[n]);
    }
}
