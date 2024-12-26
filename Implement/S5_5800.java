package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class S5_5800 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());

        int N, M;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            list.clear();
            for (int j = 0; j < N; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(list, Collections.reverseOrder());
            M = 0;
            for (int j = 1; j < N; j++) {
                M = Math.max(M, list.get(j - 1) - list.get(j));
            }

            sb.append("Class " + i + "\n");
            sb.append("Max " + list.get(0) + ", Min " + list.get(N-1) + ", Largest gap " + M).append("\n");
        }
        System.out.print(sb);
    }
}
