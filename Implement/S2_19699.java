package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class S2_19699 {

    static int N, M;
    static int[] nums;
    static boolean[] used;
    static Set<Integer> set, set2;    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        init();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        used = new boolean[N];

        st = new StringTokenizer(br.readLine());
        set2 = new HashSet<>();
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        check(0,0, 0);

        List<Integer> list = new ArrayList<>();
        if(set2.size() == 0) {
            System.out.print(-1);
            return;
        }
        
        for (int n : set2) {
            list.add(n);
        }

        Collections.sort(list);
        for (int n : list) {
            sb.append(n + " ");
        }

        System.out.print(sb.toString());
    }

    static void check(int idx, int sum, int cnt) {
        if (cnt == M) {
            if (set.contains(sum)) {
                set2.add(sum);
                return;
            }
        }

        for (int i = idx; i < N; i++) {
            if (used[i]) continue;
            
            used[i] = true;
            check(i, sum + nums[i], cnt + 1);
            used[i] = false;
        }
    }
    static void init() {
        set = new HashSet<>();

        boolean[] isPrime = new boolean[10001];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i <= 10000; i++) {
            if(isPrime[i]) {
                for (int j = i * i; j <= 10000; j += i) {
                    isPrime[j] = false; 
                }
            }
        }

        for (int i = 2; i <= 10000; i++) {
            if(isPrime[i]) set.add(i);
        }
    }
}
