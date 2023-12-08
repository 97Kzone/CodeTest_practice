package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class G3_1082 {

    static int N, M;
    static int[] nums;
    static List<Integer> ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        ans = new ArrayList<>();
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        int m = check(0);
        
        int cost = 0;
        if (m == 0) {
            int nxt = check(1);

            if (nums[nxt] > M) {
                System.out.println(0);
                return;
            } else {
                ans.add(nxt);
                cost += nums[nxt];
            }
        }
        
        while (cost + nums[m] <= M) {
            ans.add(m);
            cost += nums[m];
        }

        int a;
        for (int i = 0; i < ans.size(); i++) {
            a = ans.get(i);
            for (int j = N - 1; j >= 0; j--) {
                if (cost - nums[a] + nums[j] <= M) {
                    cost += nums[j] - nums[a];
                    ans.set(i, j);
                    break;
                }
            }
        }
        
        for (int n : ans) {
            sb.append(n);
        }

        System.out.print(sb.toString());
    }
    
    static int check(int start) {
        int res = 0;
        int std = 51;
        for (int i = start; i < N; i++) {
            if (nums[i] < std) {
                std = nums[i];
                res = i;
            } else if (nums[i] == std) {
                res = i;
            }
        }

        return res;
    }
}
