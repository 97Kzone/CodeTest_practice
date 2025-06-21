package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class S5_32172 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();

        int A = 0;
        int nxt, now;
        for (int i = 1; i <= N; i++) {
            nxt = A - i;

            if (nxt <= 0 || set.contains(nxt)) {
                now = A + i;
            } else {
                now = nxt;
            }

            set.add(now);
            A = now;
        }

        System.out.print(A);
    }
}
