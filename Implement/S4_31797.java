package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class S4_31797 {

    static int N, M;
    static List<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        list.add(new int[] { 0, 0 });
        
        int a, b;
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            list.add(new int[] { i, a });
            list.add(new int[] { i, b });
        }
        
        Collections.sort(list, (o1, o2) -> (o1[1] - o2[1]));
        
        int std = N % (M * 2) == 0 ? M * 2 : N % (M * 2);
        System.out.print(list.get(std)[0]);
    }
}
