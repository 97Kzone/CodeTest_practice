package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class G5_25391 {

    static int N, M, K;
    List<int[]> num1, num2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        List<int[]> num1 = new ArrayList<>();
        List<int[]> num2 = new ArrayList<>();
        int a, b;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            num1.add(new int[] { a, b });
        }

        num1.sort((o1, o2) -> {
            if(o1[1] == o2[1]) return o2[0] - o1[0];
            else return o2[1] - o1[1];
        });

        long res = 0;
        for (int i = 0; i < K; i++) {
            res += num1.get(i)[0];
        }

        int[] now;
        for (int i = 0; i < N - K; i++) {
            now = num1.get(i + K);
            num2.add(new int[] { now[0], now[1] });
        }

        num2.sort((o1, o2) -> {
            if (o1[0] == o2[0]) return o2[1] - o1[1];
            else return o2[0] - o1[0];
        });

        for (int i = 0; i < M; i++) {
            res += num2.get(i)[0];
        }

        System.out.print(res);
    }
}
