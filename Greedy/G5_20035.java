package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class G5_20035 {
    
    static int N, M;
    static int[] Ncnt, Mcnt;
    static List<Integer> num1, num2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Ncnt = new int[N];
        Mcnt = new int[M];

        int std = 0, sa = 0, sb = 0;
        int idx1 = 0, idx2 = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Ncnt[i] = Integer.parseInt(st.nextToken());
            sa += Ncnt[i];
            if (std < Ncnt[i]) {
                std = Ncnt[i];
                idx1 = i;
            }
        }

        for (int i = N - 1; i > 0; i--) {
            if (Ncnt[i] == std) {
                idx2 = i;
                break;
            }
        }

        int maxM = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            Mcnt[i] = Integer.parseInt(st.nextToken());
            maxM = Math.max(maxM, Mcnt[i]);
            sb += Mcnt[i];
        }

        long res = sa + std * (M - 1);
        res *= 1000000000;
        res += sb + Mcnt[0] * idx1;

        if (idx1 != idx2) {
            res += (idx2 - idx1) * maxM + Mcnt[M - 1] * (N - idx2 - 1);
        } else {
            res += Mcnt[M - 1] * (N - idx1 - 1);
        }

        System.out.print(res);
    }
}
