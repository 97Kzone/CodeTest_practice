package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_17204 {

    static int N, K;
    static int[] nums;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = new int[N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        int res = 0;
        int idx = 0;
        while (true) {
            if (idx == K)
                break;

            if (visit[idx]) {
                res = -1;
                break;
            }

            visit[idx] = true;
            idx = nums[idx];
            res++;
        }
        
        System.out.print(res);
    }  
}
