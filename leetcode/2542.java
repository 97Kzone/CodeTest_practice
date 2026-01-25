package leetcode;

import java.util.*;

class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pairs = new int[n][2];

        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums2[i];
            pairs[i][1] = nums1[i];
        }

        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;
        long res = 0;

        for (int i = 0; i < n; i++) {
            pq.offer(pairs[i][1]);
            sum += pairs[i][1];

            if (pq.size() > k) {
                sum -= pq.poll();
            }

            if (pq.size() == k) {
                res = Math.max(res, sum * pairs[i][0]);
            }
        }

        return res;
    }
}