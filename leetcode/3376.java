package leetcode;

import java.util.*;

class Solution {

    static int N, K;
    static List<Integer> str;
    static int res;
    static boolean[] visit;

    public int findMinimumTime(List<Integer> strength, int k) {
        N = strength.size();
        K = k;
        str = strength;
        visit = new boolean[N];
        res = Integer.MAX_VALUE;
        
        dfs(0, 1, 0);

        return res;
    }

    static void dfs(int d, int x, int t) {
        if (t >= res) return;

        if (d == N) {
            res = Math.min(res, t);
            return;
        }

        int tmp;
        for (int i = 0; i < N; i++) {
            if (visit[i]) continue;

            visit[i] = true;
            tmp = (str.get(i) + x - 1) / x;
            dfs(d + 1, x + K, t + tmp);
            visit[i] = false;
        }
    }
}