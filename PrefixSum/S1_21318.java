package PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_21318 {
    static int N, M, cnt;
    static int[] arr;
    static int[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        sum = new int[N + 1];

        String[] S = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(S[i - 1]);
            if (arr[i - 1] > arr[i]) {
                sum[i] += sum[i - 1] + 1;
            } else {
                sum[i] = sum[i - 1];
            }
        }

        M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int s, e;
        for (int i = 0; i < M; i++) {
            String[] s1 = br.readLine().split(" ");
            s = Integer.parseInt(s1[0]);
            e = Integer.parseInt(s1[1]);
            sb.append(sum[e] - sum[s]).append("\n");
            cnt = 0;
        }
        System.out.println(sb.toString());
    }
}
