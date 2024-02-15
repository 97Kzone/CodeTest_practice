package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_27952 {

    static int N, X;
    static int[] numA, numB;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        numA = new int[N];
        numB = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numB[i] = Integer.parseInt(st.nextToken());
        }

        long std = 0;
        long res = 0;

        for (int i = 0; i < N; i++) {
            std += numB[i];

            if (std < numA[i]) {
                res = -1;
                break;
            }
        }

        res = (std - numA[N - 1]) / X;
        System.out.print(res);
    }
}
