package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_12033 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        int N, L, cnt;
        int[] nums, res;
        boolean[] visit;

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            L = N * 2;
            nums = new int[L];
            res = new int[N];
            visit = new boolean[L];
            
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < L; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
            
            cnt = 0;
            for (int i = 0; i < L; i++) {
                if (cnt == N)
                    break;

                if (visit[i] || nums[i] % 3 != 0)
                    continue;
                
                visit[i] = true;
                long std = (nums[i] / 3) * 4;
                for (int j = i + 1; j < L; j++) {
                    if (!visit[j] && std == nums[j]) {
                        res[cnt] = nums[i];
                        visit[j] = true;
                        cnt++;
                        break;
                    }
                }
            }
            sb.append("Case #" + t + ": ");
            for (int n : res) sb.append(n + " ");
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
}
