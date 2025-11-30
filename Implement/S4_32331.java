package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class S4_32331 {

    static int N, M, X, Y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        st.nextToken();

        long std = Long.parseLong(st.nextToken());

        List<Integer> list = new ArrayList<>();
        int a, b;
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken().substring(0, 4));
            b = Integer.parseInt(st.nextToken());

            if (a != 2024) continue;

            list.add(Y < X - b ? b : b + Y - (X - b));
        }

        Collections.sort(list, (o1, o2) -> (o2 - o1));

        if (M - 1 >= list.size() || list.get(M - 1) <= std) {
            bw.write("YES\n");
            bw.write("0");
        } else if (list.get(M - 1) <= std + Y) {
            bw.write("YES\n");
            bw.write((list.get(M-1) - std) + "");
        } else {
            bw.write("NO");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
