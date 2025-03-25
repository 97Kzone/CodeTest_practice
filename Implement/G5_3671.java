package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class G5_3671 {

    static HashSet<Integer> set;
    static StringBuilder sb;
    static char[] num;

    static HashSet<Integer> set2;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        init();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            num = br.readLine().toCharArray();

            set2 = new HashSet<>();
            used = new boolean[num.length];
            check("");

            int res = 0;
            for (int v : set2) {
                if (!set.contains(v)) continue;
                res++;
            }

            sb.append(res + "\n");
        }

        System.out.print(sb.toString());
    }

    static void check(String now) {
        if (!now.isEmpty()) {
            set2.add(Integer.parseInt(now));
        }

        for (int i = 0; i < num.length; i++) {
            if(!used[i]) {
                used[i] = true;
                check(now + num[i]);
                used[i] = false;
            }
        }
    }

    static void init() {
        set = new HashSet<>();
        boolean[] isPrime = new boolean[10000001];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= 10000000; i++) {
            if(isPrime[i]) {
                for (int j = i * i; j <= 10000000; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i <= 10000000; i++) {
            if(isPrime[i]) set.add(i);
        }

    }
}
