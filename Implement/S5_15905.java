package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class S5_15905 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();

        int a, b;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            list.add(new int[] { a, b });
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) return o2[0] - o1[0];
                else return o2[1] - o1[1];
            }            
        }); 
        int cnt = list.get(4)[0];
        int std = list.get(4)[1];

        int res = 0;
        for (int[] n : list) {
            if (n[0] == cnt) {
                if (n[1] < std) {
                    res++;
                }
            }
        }

        System.out.print(res);
    }
}
