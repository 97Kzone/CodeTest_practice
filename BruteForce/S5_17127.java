package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_17127 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        long res = -1;
        int[] num = new int[N];
        int[] num2 = new int[N+1];
        num2[0] = 1;
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            num2[i] = num2[i - 1] * num[i - 1];
        }

        int std;
        for (int i = 0; i < N - 3; i++) {
            for (int j = i + 1; j < N - 2; j++) {
                for (int k = j + 1; k < N - 1; k++) {
                    std = num2[i + 1] / num2[0];
                    std += num2[j + 1] / num2[i + 1];
                    std += num2[k + 1] / num2[j + 1];
                    std += num2[N] / num2[k + 1];

                    res = Math.max(res, std);
                }
            }
        }
        
        System.out.print(res);
    }
}
