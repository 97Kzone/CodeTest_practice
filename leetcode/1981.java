package leetcode;

import java.util.*;

class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        Set<Integer> cur = new HashSet<>();
        cur.add(0);

        for (int[] row : mat) {
            Set<Integer> nxt = new HashSet<>();
            for (int s : cur) {
                for (int v : row) {
                    nxt.add(s + v);
                }
            }

            List<Integer> list = new ArrayList<>(nxt);
            list.sort(Comparator.comparingInt(a -> Math.abs(a - target)));

            cur.clear();
            for (int i = 0; i < Math.min(2000, list.size()); i++) {
                cur.add(list.get(i));
            }
        }

        int res = Integer.MAX_VALUE;
        for (int s : cur) {
            res = Math.min(res, Math.abs(s - target));
        }
        return res;
    }
}