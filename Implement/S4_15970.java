package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class S4_15970 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        int a, b;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            list.get(b).add(a);
        }

        for (int i = 0; i <= N; i++) {
            Collections.sort(list.get(i));
        }

        int res = 0;
        ArrayList<Integer> n;
        int n1, n2;
        for (int i = 0; i <= N; i++) {
            n = list.get(i);
            for (int j = 0; j < n.size(); j++) {
                if (j == 0)
                    res += n.get(j + 1) - n.get(j);
                else if (j == n.size() - 1) {
                    res += n.get(j) - n.get(j - 1);
                } else {
                    n1 = n.get(j + 1) - n.get(j);
                    n2 = n.get(j) - n.get(j - 1);
                    
                    res += Math.min(n1, n2);
                }
            }
        }

        System.out.print(res);
    }
}
