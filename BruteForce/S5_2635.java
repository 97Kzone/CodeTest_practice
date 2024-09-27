package BruteForce;

import java.io.*;
import java.util.*;

public class S5_2635 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        int v1, v2;
        int res = 0; 
        for (int i = 1; i <= N; i++) {
            list.clear();
            list.add(N);
            list.add(i);

            int idx = 0;
            while (true) {
                v1 = list.get(idx);
                v2 = list.get(idx + 1);

                if (v1 - v2 < 0) {
                    break;
                }

                list.add(v1 - v2);
                idx++;
            }

            if (list.size() > res) {
                res = list.size();
                list2 = new ArrayList<>(list);
            }
        }
        sb.append(res + "\n");
        for (int n : list2) {
            sb.append(n + " ");
        }
        System.out.print(sb);
    }
}
