package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_32396 {

    static int N;
    static long M;
    static long[] nums;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());

        nums = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }

        visit = new boolean[N];
        int cnt = 0;

        long std;
        for (int i = 1; i < N; i++) {
            std = Math.abs(nums[i] - nums[i - 1]);
            if (!visit[i - 1] && std < M) {
                visit[i] = true;
                cnt++;
            }
        }

        System.out.print(cnt);

    }
}
