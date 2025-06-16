package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_2840 {

    static int N, K;
    static char[] check;
    static boolean[] words;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        words = new boolean[26];
        check = new char[N];
        Arrays.fill(check, '?');

        int std = 0;
        int tmp;
        char c;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            tmp = Integer.parseInt(st.nextToken());
            std = (std + N - (tmp % N)) % N;
            c= st.nextToken().charAt(0);

            if (check[std] == c) continue;

            if (check[std] != '?') {
                System.out.println("!");
                return;
            }

            if (check[std] == '?' && !words[c - 'A']) {
                check[std] = c;
                words[c - 'A'] = true;
            } else {
                System.out.println("!");
                return;
            }
        }
        for (int i = 0; i < N; i++) {
            sb.append(check[(std + i) % N]);
        } 

        System.out.print(sb.toString());
    }
}
