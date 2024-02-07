package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S3_27446 {
    
    static int N, M;
    static int[] nums;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        
        int a;
        for (int i = 0; i < M; i++) {
            a = Integer.parseInt(st.nextToken());
            nums[a] = 1;
        }
        
        list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (nums[i] == 0) list.add(i);
        }
        
        int res = 0;
        int std = 0, idx = 0;
        while (idx < list.size()) {
            std = list.get(idx++);
            a = std;

            while (idx < list.size() && list.get(idx) <= std + 3) {
                std = list.get(idx++);
            }
            res += 7 + 2 * (std - a);
        }

        System.out.print(res);

    }
}
