package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class S5_3230 {

    static int N, M;
    static LinkedList<Integer> list1, list2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list1 = new LinkedList<>();
        list2 = new LinkedList<>();

        int a, b;
        for (int i = 0; i < N; i++) {
            a = Integer.parseInt(br.readLine()) - 1;
            list1.add(a, i);
        }

        for (int i = M; i > 0; i--) {
            a = list1.get(i - 1);
            b = Integer.parseInt(br.readLine()) - 1;
            list2.add(b, a);
        }

        for (int i = 0; i < 3; i++) {
            sb.append(list2.get(i) + 1).append("\n");
        }

        System.out.print(sb.toString());
    }
}
