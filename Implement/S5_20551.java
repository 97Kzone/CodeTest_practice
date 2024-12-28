package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class S5_20551 {

    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(nums);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (map.containsKey(nums[i]))
                continue;

            map.put(nums[i], i);
        }
        
        int tmp;
        while (M > 0) {
            tmp = Integer.parseInt(br.readLine());

            if (map.containsKey(tmp)) {
                sb.append(map.get(tmp) + "\n");
            } else {
                sb.append("-1" + "\n");
            }
            M--;
        }

        System.out.print(sb);
    }
}
