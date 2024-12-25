package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S5_11971 {

    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        int a, b;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            for (int j = 0; j < a; j++) {
                list1.add(b);
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            for (int j = 0; j < a; j++) {
                list2.add(b);
            }
        }

        int res = 0;
        for (int i = 0; i < 100; i++) {
            if (list2.get(i) - list1.get(i) <= res)
                continue;

            res = list2.get(i) - list1.get(i);
        }
        
        System.out.print(res);
    }
}
