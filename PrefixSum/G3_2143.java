package PrefixSum;

import java.util.HashMap;
import java.util.Scanner;

public class G3_2143 {
    static int T, N, M;
    static long[] a, b;
    static HashMap<Long, Integer> std;
    public static void main(String[] args) {
        sol();
    }

    static void sol() {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        N = sc.nextInt();
        a = new long[N+1];
        for (int i = 1; i < N+1; i++) {
            a[i] = sc.nextInt();
            
        }

        M = sc.nextInt();
        b = new long[M+1];
        for (int i = 1; i < M+1; i++) {
            b[i] = sc.nextInt();
        }

        for (int i = 1; i < N+1; i++) {
            a[i] += a[i-1];
        }

        for (int i = 1; i < M+1; i++) {
            b[i] += b[i-1];
        }

        std = new HashMap<>();
        long tmp;
        for (int i = 1; i < M+1; i++) {
            tmp = 0;
            for (int j = i; j < M+1; j++) {
                tmp = b[j] - b[i-1];
                if (std.containsKey(tmp)) {
                    std.put(tmp, std.get(tmp)+1);
                } else {
                    std.put(tmp, 1);
                }
            }
        }

        long res = 0;
        for (int i = 1; i < N+1; i++) {
            for (int j = i; j < N+1; j++) {
                tmp = a[j] - a[i-1];
                if (std.containsKey(T-tmp)) {
                    res += std.get(T-tmp);
                }
            }
        }

        System.out.println(res);
    }
}
