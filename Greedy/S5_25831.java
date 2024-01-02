package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class S5_25831 {

    static int N;
    static Map<Integer, Integer> nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        int tmp;
        for (int i = 0; i < N; i++) {
            tmp = Integer.parseInt(st.nextToken());

            if (nums.get(tmp) == null) {
                nums.put(tmp, 1);
            } else {
                nums.put(tmp, nums.get(tmp) + 1);
            }
        }  

        int res = 0;
        for (int k : nums.keySet()) {
            res = Math.max(res, nums.get(k));
        }

        System.out.print(res);
        
    }
}
