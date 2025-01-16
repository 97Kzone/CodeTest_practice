package Adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_32711 {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            cnt += nums[i];
        }

        if (cnt % 2 == 1) {
            System.out.print(1);
            return;
        }

        int std = 0;
        for (int i = 0; i < N - 1; i++) {
            std += nums[i];
            if (std % 2 == 0) {
                System.out.print(1);
                return;
            }
        }

        System.out.print(0);
    }
}
