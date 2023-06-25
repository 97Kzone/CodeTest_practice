package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S3_25945 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        int sum = 0;
        List<Integer> nums = new ArrayList<>();

        int num;
        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(st.nextToken());
            nums.add(num);
            sum += num;
        }

        // 평균값과 값 비교
        int avg = sum / N;
        int l = 0, r = 0;
        for (int v : nums) {
            if (v > avg)
                l += v - avg - 1;
            else 
                r += avg - v;
        }

        System.out.print(Math.max(l, r));
    }
}
