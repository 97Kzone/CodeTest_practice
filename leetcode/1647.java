package leetcode;

import java.util.*;

class Solution {
    public int minDeletions(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        Arrays.sort(cnt); 

        int res = 0;
        int std = Integer.MAX_VALUE;
        int tmp;
        for (int i = 25; i >= 0; i--) {
            if (cnt[i] == 0) continue;

            if (cnt[i] >= std) {
                tmp = Math.max(0, std - 1);
                res += cnt[i] - tmp;
                cnt[i] = tmp;
            }

            std = cnt[i];
        }

        return res;
    }
}