package Implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class S4_34803 {
    static int L, N, K;
    static List<String> list;
    static Set<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        list = new ArrayList<>();
        set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }
        
        K = Integer.parseInt(br.readLine());
        int res = 0;

        for (int i = 0; i < N; i++) {
            String now = list.get(i);
            for (int j = 0; j <= (L - K); j++) {
                set.add(now.substring(j, j + K));
            }
        }
        
        int std;
        String now;
        for (String partial : set) {
            std = 0;
            for (int i = 0; i < N; i++) {
                now = list.get(i);
                for (int j = 0; j <= (L - K); j++) {
                    if (now.substring(j, j + K).equals(partial)) {
                        std++;
                    }
                }
            }
            res = Math.max(res, std);
        }

        System.out.println(res);
    }
}
