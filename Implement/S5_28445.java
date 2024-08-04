package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

public class S5_28445 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        HashSet<String> color = new HashSet<>();
        
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 2; j++) {
                color.add(st.nextToken());
            }
        }
        int N = color.size();
        String[][] res = new String[N * N][2];
        
        int i = 0;
        int j;
        for (String c1 : color) {
            j = 0;
            for (String c2 : color) {
                res[i * N + j][0] = c1;
                res[i * N + j][1] = c2;
                j++;
            }
            i++;
        }

        Arrays.sort(res, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (o1[0].toString().contentEquals(o2[0].toString())) {
                    return o1[1].toString().compareTo(o2[1].toString());
                } else {
                    return o1[0].toString().compareTo(o2[0].toString());
                }
            }
        });

        for (i = 0; i < N * N; i++) {
            System.out.println(res[i][0] + " " + res[i][1]);
        }
    }
}
