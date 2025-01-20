package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class S4_25192 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        int res = 0;
        String s;
        for (int i = 0; i < N; i++) {
            s = br.readLine();

            if ("ENTER".equals(s)) {
                set.clear();
                continue;
            }

            if (set.contains(s)) {
                continue;
            }

            res++;
            set.add(s);
        }
        
        System.out.print(res);
    }
}
