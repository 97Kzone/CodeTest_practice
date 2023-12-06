package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class G5_1263 {
    
    static int N;
    static List<int[]> nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new ArrayList<>();

        int t, s;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            t = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());

            nums.add(new int[] { t, s });
        }

        Collections.sort(nums, (o1, o2) -> (o2[1] - o1[1]));
        int res = nums.get(0)[1] - nums.get(0)[0];
        
        for (int i = 1; i < N; i++) {
            if (nums.get(i)[1] < res) {
                res = nums.get(i)[1];
            }
            res = res - nums.get(i)[0];
        }

        System.out.print(res > 0 ? res : -1);
    }
}
