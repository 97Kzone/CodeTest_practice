package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class S5_32942 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Set<Integer>[] sets = new HashSet[11];
        for (int i = 0; i < 11; i++) {
            sets[i] = new HashSet<Integer>();
        }

        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                if (A * i + B * j == C) {
                    sets[i].add(j);
                }
            }

            if (sets[i].size() == 0) {
                System.out.println(0);
            } else {
                for (int num : sets[i]) {
                    System.out.println(num);
                }  
            }
        }
    }
}
