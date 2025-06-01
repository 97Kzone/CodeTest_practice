package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S3_27922 {

    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] nums12 = new int[N];
        int[] nums23 = new int[N];
        int[] nums13 = new int[N];

        int a, b, c;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            nums12[i] = a + b;
            nums23[i] = b + c;
            nums13[i] = a + c;
        }

        Arrays.sort(nums12);
        Arrays.sort(nums23);
        Arrays.sort(nums13);

        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        for (int i = N - K; i < N; i++) {
            v1 += nums12[i];
            v2 += nums23[i];
            v3 += nums13[i];   
        }

        int res = Math.max(v1, Math.max(v2, v3));
        System.out.print(res);

    }
}