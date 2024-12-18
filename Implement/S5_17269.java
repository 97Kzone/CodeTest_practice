package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_17269 {

    static int[] score = { 3, 2, 1, 2, 4, 3, 1, 3, 1, 1, 3, 1, 3, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1 };
    static int[] nums;
    static int std;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        std = Math.min(N, M);
        
        st = new StringTokenizer(br.readLine());
        int[] num1 = new int[N];
        int[] num2 = new int[M];

        String s = st.nextToken();
        for (int i = 0; i < N; i++) {
            num1[i] = score[s.charAt(i) - 'A'];
        }

        s = st.nextToken();
        for (int i = 0; i < M; i++) {
            num2[i] = score[s.charAt(i) - 'A'];
        }

        nums = new int[N + M];
        for (int i = 0; i < std; i++) {
            nums[i * 2] = num1[i];
            nums[i * 2 + 1] = num2[i];
        }

        if (N > M) {
            for (int i = std; i < N; i++) {
                nums[std * 2 + i - std] = num1[i];
            }
        } else {
            for (int i = std; i < M; i++) {
                nums[std * 2 + i - std] = num2[i];
            }
        }

        for (int i = 0; i < N + M - 2; i++) {
            for (int j = 0; j < N + M - i - 1; j++) {
                nums[j] = (nums[j] + nums[j + 1]) % 10;
            }
        }
        System.out.print(nums[0] * 10 + nums[1] + "%");
    }
}
