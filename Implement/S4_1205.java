package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_1205 {

    static int N, P, score;
    static int[] scores;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        score = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        if (N == 0) {
            System.out.println(1);
            return;
        }

        scores = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        int rank = 1;
        for (int i = 0; i < N; i++) {
            if (score < scores[i]) {
                rank++;
            } else {
                break;
            }
        }

        if (N == P && score <= scores[N - 1]) {
            System.out.println(-1);
        } else {
            System.out.println(rank);
        }
    }
}
