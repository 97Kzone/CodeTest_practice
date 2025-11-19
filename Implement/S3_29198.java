package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_29198 {

    static int N, M, K;
    static String[] words;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        words = new String[N];
        char[] tmp;
        for (int i = 0; i < N; i++) {
            tmp = br.readLine().toCharArray();
            Arrays.sort(tmp);

            sb = new StringBuilder();
            for (int j = 0; j < M; j++) {
                sb.append(tmp[j]);
            }

            words[i] = sb.toString();
        }  

        Arrays.sort(words);

        sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            sb.append(words[i]);
        }

        tmp = sb.toString().toCharArray();
        Arrays.sort(tmp);

        sb = new StringBuilder();
        for (int i = 0; i < M * K; i++) {
            sb.append(tmp[i]);
        }

        System.out.print(sb.toString());

    }
}
