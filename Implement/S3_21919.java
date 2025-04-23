package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class S3_21919 {

    static int N;
    static boolean[] isPrime;
    static Set<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        init();

        N = Integer.parseInt(br.readLine());
        list = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        int num;
        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(st.nextToken());
            if (!isPrime[num]) continue;

            list.add(num);
        }

        if (list.size() == 0) {
            System.out.print(-1);
            return;
        }

        long res = 1;
        for (int n : list) {
            res *= n;
        }

        System.out.print(res);
    }

    static void init() {
        isPrime = new boolean[1000001];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i <= 1000000; i++) {
            if (!isPrime[i]) continue;

            for (int j = i + i; j <= 1000000; j += i) {
                isPrime[j] = false;
            }
        }
    }
}
