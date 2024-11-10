package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class S2_30804 {
    
    static int N;
    static Map<Integer, Integer> map;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        int n;
        for (int i = 0; i < N; i++) {
            n = Integer.parseInt(st.nextToken());
            nums[i] = n;
        }

        int res = 0;
        int idx = 0;

        for (int i = 0; i < N; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            while (map.size() > 2) {
                map.put(nums[idx], map.get(nums[idx]) - 1);

                if (map.get(nums[idx]) == 0) {
                    map.remove(nums[idx]);
                }
                idx++;
            }
            res = Math.max(res, i - idx + 1);
        }
        System.out.print(res);
    }
}
