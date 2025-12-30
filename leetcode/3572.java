package leetcode;

import java.util.*;

class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        int N = x.length;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list;

        for (int i = 0; i < N; i++) {
            map.put(x[i], Math.max(map.getOrDefault(x[i], 0), y[i]));
        }

        if (map.size() < 3) return - 1;
        
        list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());

        int res = list.get(0) + list.get(1) + list.get(2);

        return res;
    }
}