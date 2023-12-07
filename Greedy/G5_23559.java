package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class G5_23559 {

    static int N, X, std;
    static List<int[]> nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        std = 0;
        
        nums = new ArrayList<>();
        
        int a, b;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            nums.add(new int[] { a, b });
            std += b;
        }

        Collections.sort(nums, (o1, o2) -> ((o1[1] - o1[0]) - (o2[1] - o2[0])));

        // 5000원을 몇번 고를 수 있을까?
        int cnt = (X - (N * 1000)) / 4000;
        for (int i = 0; i < N; i++) {
            if (nums.get(i)[0] < nums.get(i)[1] || cnt == 0)
                break;

            std += nums.get(i)[0];
            std -= nums.get(i)[1];

            cnt--;
        }

        System.out.print(std);
    }    
}
