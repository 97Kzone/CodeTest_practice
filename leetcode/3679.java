package leetcode;

import java.util.*;

class Solution {
    public int minArrivalsToDiscard(int[] arrivals, int w, int m) {
        int n = arrivals.length;
        Map<Integer, Deque<Integer>> check = new HashMap<>();

        int res = 0;
        int now, std;
        for (int i = 0; i < n; i++) {
            now = arrivals[i];

            check.putIfAbsent(now, new ArrayDeque<>());
            Deque<Integer> tmp = check.get(now);

            std = i - w + 1;
            while(!tmp.isEmpty() && tmp.peekFirst() < std) {
                tmp.pollFirst();
            }

            if (tmp.size() < m) tmp.offerLast(i);
            else res++;
        }

        return res;
    }
}
