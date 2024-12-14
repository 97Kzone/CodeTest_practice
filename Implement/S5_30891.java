package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S5_30891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        int a, b;
        int maxX = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            list1.add(a);
            list2.add(b);

            maxX = Math.max(maxX, a);
            minX = Math.min(minX, a);
        }

        int cnt = Integer.MIN_VALUE;
        int rx = 0;
        int ry = 0;

        int tmp;
        double std;
        for (int i = minX; i < maxX + 1; i++) {
            for (int j = minX; j < maxX + 1; j++) {
                tmp = 0;

                for (int k = 0; k < N; k++) {
                    std = Math.sqrt(Math.pow(i - list1.get(k), 2) + Math.pow(j - list2.get(k), 2));

                    if (std <= R) {
                        tmp++;
                    }
                }

                if (cnt < tmp) {
                    cnt = tmp;
                    rx = i;
                    ry = j;
                }
            }
        }

        System.out.print(rx + " " + ry);
    }
}
