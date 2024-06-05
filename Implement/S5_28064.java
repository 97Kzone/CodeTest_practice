package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class S5_28064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        String s1, s2;
        int l1, l2, std;
        int res = 0;
        boolean flag;
        for (int i = 0; i < N - 1; i++) {
            s1 = list.get(i);
            l1 = s1.length();
            for (int j = i + 1; j < N; j++) {
                s2 = list.get(j);
                l2 = s2.length();
                flag = false;

                std = Math.min(l1, l2);
                for (int k = 1; k <= std; k++) {
                    if (s2.endsWith(s1.substring(0, k)) || s1.endsWith(s2.substring(0, k))) {
                        flag = true;
                        break;
                    }
                }

                if (flag) res++;
            }
        }

        System.out.print(res);
    }
}
