package contest.boramae;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[100001];

        int std = 0;
        st = new StringTokenizer(br.readLine());
        
        int idx;
        for (int i = 0; i < N; i++) {
            idx = Integer.parseInt(st.nextToken());
            nums[idx]++;

            if (std < nums[idx]) {
                std = nums[idx];
            }
        }

        if (N - std >= N / 2) System.out.print("YES");
        else System.out.print("NO");
    }
}
