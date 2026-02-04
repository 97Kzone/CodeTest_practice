package leetcode;

import java.util.*;

class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        int N = nums.length;

        int cnt1 = 0;
        for (int num : nums) {
            if (num == 1) cnt1++;
        }

        List<Integer> res = new ArrayList<>();
        int zero = 0;
        int one = 0;
        int max = -1;

        int v;
        for (int i = 0; i <= N; i++) {
            v = zero + (cnt1 - one);

            if (v > max) {
                max = v;
                res.clear();
                res.add(i);
            } else if (v == max) {
                res.add(i);
            }

            if (i < N) {
                if (nums[i] == 0) zero++;
                else one++;
            }
        }

        return res;
    }
}
