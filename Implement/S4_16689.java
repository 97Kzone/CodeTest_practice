package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S4_16689 {

    static int N;
    static List<int[]> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        int a, b;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            list.add(new int[] {a, b});
        }

        int res = N;
        int cnt;
        int[] now;
        while(true) {
            cnt = 0;
            if (res == -1) break;
            for (int i = 0; i < N; i++) {
                now = list.get(i);
                a = now[0];
                b = now[1];

                if (a <= res && res <= b) cnt++;
            }

            if (cnt == res) break;
            res--;
        }

        System.out.print(res);
    }
}
