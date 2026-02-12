package leetcode;

import java.util.*;

class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int N = s.length();
        Set<String> set = new HashSet<>();
        for (String word : dictionary) {
            set.add(word);
        }

        int[] dp = new int[N + 1];
        dp[N] = 0; 

        for (int i = N - 1; i >= 0; i--) {
            dp[i] = dp[i + 1] + 1;

            for (int j = i; j < N; j++) {
                if (set.contains(s.substring(i, j + 1))) {
                    dp[i] = Math.min(dp[i], dp[j + 1]);
                }
            }
        }

        return dp[0];
    }
}