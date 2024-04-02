package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_14863 {

    static int N, K;
    static int[] time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        time = new int[K + 1];
        time[0] = 1;

        int a, b, c, d;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            for (int j = K; j >= 0; j--) {
                if (time[j] != 0) {
                    if (j + a <= K) time[j + a] = Math.max(time[j + a], time[j] + b);
                    if (j + c <= K) time[j + c] = Math.max(time[j + c], time[j] + d);
                    
                    time[j] = 0; // 이미 지나간 시간은 지워야한다
                }
            }
        }

        int res = 0;
        for (int i = 0; i <= K; i++) res = Math.max(res, time[i]);
        System.out.print(res - 1);
    }
}
