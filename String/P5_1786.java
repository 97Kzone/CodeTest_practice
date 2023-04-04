package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P5_1786 {
    static char[] input, patt;
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
        StringBuilder sb = new StringBuilder();

        input = br.readLine().toCharArray();
        patt = br.readLine().toCharArray();

        // 부분 문자열 테이블
        int il = input.length;
        int pl = patt.length;
        p = new int[pl];
        for (int i = 1, j = 0; i < pl; i++) {
            while(j > 0 && patt[i] != patt[j]) j = p[j-1];
            
            if (patt[i] == patt[j]) p[i] = ++j;
            else p[i] = 0;
        }

        int cnt = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0, j = 0; i < il; i++) {
            while (j > 0 && input[i] != patt[j]) j = p[j-1];

            if (input[i] == patt[j]) {
                if ( j == pl - 1) {
                    cnt++;
                    list.add(i - j + 1);
                    j = p[j];
                } else j++;
            }
        }
        System.out.println(cnt);
        for (int n : list) sb.append(n + " ");

        System.out.print(sb.toString());
    }
}
