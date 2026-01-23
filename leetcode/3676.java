package leetcode;

import java.util.*;

class Solution {
    public long bowlSubarrays(int[] nums) {
        int N = nums.length;
        boolean[] hasLeftGreater = new boolean[N];
        boolean[] hasRightGreater = new boolean[N];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) hasLeftGreater[i] = true;
            stack.push(i);
        }

        stack.clear();

        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) hasRightGreater[i] = true;
            stack.push(i);
        }

        long res = 0;
        for (int i = 0; i < N; i++) {
            if (hasLeftGreater[i] && hasRightGreater[i]) {
                res++;
            }
        }

        return res;
    }
}