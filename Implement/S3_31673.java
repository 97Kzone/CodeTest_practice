package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class S3_31673 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> nums = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        long std = 0;
        for (int i = 0; i < N; i++) {
            nums.add(Integer.parseInt(st.nextToken()));
            std += nums.get(i);
        }

        Collections.sort(nums, Collections.reverseOrder());
        long cnt = 0;
        long v = 0;

        if (std % 2 == 0) {
            std /= 2;
        } else {
            std = (std / 2) + 1;
        }

        for (int i = 0; i < N; i++) {
            if (v >= std) {
                break;
            }

            v += nums.get(i);
            cnt++;
        }
        
        System.out.print(M / (cnt + 1));
    }
}
