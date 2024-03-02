package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_23322 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int std = Integer.parseInt(st.nextToken());
        int res1 = 0;
        int res2 = 0;

        int tmp;
        while (st.hasMoreTokens()) {

            tmp = Integer.parseInt(st.nextToken());
            if (tmp == std) continue;

            res1++;
            res2 += tmp - std;
        }

        System.out.print(res2 + " " + res1);
    }
}
