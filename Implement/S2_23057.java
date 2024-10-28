package Implement;

import java.io.*;
import java.util.*;

public class S2_23057 {

    static int N, M;
    static int[] nums;
    static Set<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = 0;
        nums = new int[N];
        set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            M += nums[i];
        }

        check(0, 0);
        System.out.print(M - set.size() + 1);
    }
    
    static void check(int v, int res) {
        if (v == N) {
            set.add(res);
            return;
        }

        check(v + 1, res + nums[v]);
        check(v + 1, res);
    }
}
