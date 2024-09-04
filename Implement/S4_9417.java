package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S4_9417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        long l, res, std;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.clear();
            while (st.hasMoreTokens()) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            l = list.size();

            res = 1;
            std = 0;
            for (int j = 0; j < l - 1; j++) {
                for (int k = j + 1; k < l; k++) {
                    std = gcd(list.get(j), list.get(k));
                    res = Math.max(res, std);
                }

            }

            sb.append(res + "\n");
        }
        System.out.print(sb);

    }

    static long gcd(long a, long b) {
        long tmp;
        while (b > 0) {
            tmp = b;
            b = a % b;
            a = tmp;
        }

        return a;
    }
}
