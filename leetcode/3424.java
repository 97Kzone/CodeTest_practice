package leetcode;

import java.util.*;

class Solution {
    public long minCost(int[] arr, int[] brr, long k) {
        long res = Long.MAX_VALUE;
        int N = arr.length;

        long std = 0;
        for (int i = 0; i < N; i++) {
            std += Math.abs(arr[i] - brr[i]);
        }

        res = Math.min(res, std);

        Arrays.sort(arr);
        Arrays.sort(brr);

        std = k;
        for (int i = 0; i < N; i++) {
            std += Math.abs(arr[i] - brr[i]);
        }

        res = Math.min(res, std);

        return res;
    }
}
