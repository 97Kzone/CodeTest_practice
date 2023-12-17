package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G3_16207 {

    static int N;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        // 1. 정렬을 한다
        Arrays.sort(nums);

        // 2. 4칸씩 썰어서 탐색을 한다...
        int i = N - 1;
        long idx1 = 0, idx2 = 0;
        long res = 0;
        while (i >= 1) {
            if (nums[i] - nums[i - 1] == 0) {
                if (idx1 == 0) idx1 = nums[i];
                else idx2 = nums[i];
                i -= 2;
            } else if (nums[i] - nums[i - 1] == 1) {
                if (idx1 == 0) idx1 = nums[i - 1];
                else idx2 = nums[i - 1];
                i -= 2;
            } else i--;
            
            if (idx1 != 0 && idx2 != 0) {
                res += idx1 * idx2;
                idx1 = 0;
                idx2 = 0;
            }           
        }
        System.out.print(res);
    }
}
