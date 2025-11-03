package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_30959 {

    static int N, M;
    static int[] std;
    static int[][] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        std = new int[M];
        nums = new int[N][M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            std[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int res = 0;
        int cnt;
        for (int i = 0; i < N; i++) {
            cnt = 0;
            for (int j = 0; j < M; j++) {
                cnt += nums[i][j] == std[j] ? 1 : 0;

                res = Math.max(res, cnt);
            }
        }

        int num = 1 << N;
        int v, sum, tmp;
        for (int i = 1; i < num; i++) {
            v = Integer.bitCount(i);

            if ((v & 1) == 0 || v < 3) continue;
            cnt = 0;

            for (int j = 0; j < M; j++) {
                sum = 0;
                for (int k = 0; k < N; k++) {
                    if ((i & (1 << k)) != 0) {
                        sum += nums[k][j];
                    }
                }

                tmp = (sum > v / 2) ? 1 : 0;
                cnt += tmp == std[j] ? 1 : 0;
            }

            if (cnt > res) {
                System.out.print(1);
                return;
            }
        }
        System.out.print(0);
    }    
}
