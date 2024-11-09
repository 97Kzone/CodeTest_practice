package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class S4_29891 {

    static int N, K;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        List<Integer> list1 = new ArrayList();
        List<Integer> list2 = new ArrayList();
        int n;
        for (int i = 0; i < N; i++) {
            n = Integer.parseInt(br.readLine());

            if (n < 0)
                list1.add(n);
            else
                list2.add(n);
        }

        Collections.sort(list1);
        Collections.sort(list2, Collections.reverseOrder());

        long res = 0;
        int cnt = 0;
        for (int i = 0; i < list1.size(); i++) {
            if (cnt == 0) {
                res += Math.abs(list1.get(i)) * 2;
                cnt++;
            } else if (cnt < K) {
                cnt++;
            }

            if (cnt == K)
                cnt = 0;
        }

        cnt = 0;
        for (int i = 0; i < list2.size(); i++) {
            if (cnt == 0) {
                res += list2.get(i) * 2;
                cnt++;
            } else if (cnt < K) {
                cnt++;
            }

            if (cnt == K)
                cnt = 0;
        }

        System.out.print(res);
    }
}
