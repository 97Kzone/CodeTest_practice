package BruteForce;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S3_25370 {

    static Set<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        set = new HashSet<>();
        check(1, N, 1);

        System.out.print(set.size());
    }
    
    static void check(int now, int cnt, int std) {
        if (cnt == 0) {
            set.add(now);
            return;
        }

        for (int i = 1; i <= 9; i++) {
            check(now * i, cnt - 1, i);
        }
    } 
}
