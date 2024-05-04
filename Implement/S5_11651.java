package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class S5_11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        ArrayList<int[]> list = new ArrayList<>();

        int a, b;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            list.add(new int[] { a, b });
        }
        
        Collections.sort(list, (o1, o2) -> (o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]));
        for (int[] n : list) {
            sb.append(n[0] + " " + n[1] + "\n");
        }
        
        System.out.print(sb);
    }
}
