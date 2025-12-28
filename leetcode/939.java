package leetcode;

import java.util.*;

class Solution {
    public int minAreaRect(int[][] points) {
        Set<String> set = new HashSet<>();

        for (int[] point : points) {
            set.add(point[0] + "," + point[1]);
        }

        int res = Integer.MAX_VALUE;
        int n = points.length;

        int x1, x2, y1, y2;
        int tmp;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                x1 = points[i][0];
                y1 = points[i][1];
                x2 = points[j][0];
                y2 = points[j][1];

                if (x1 == x2 || y1 == y2) continue;
                
                if (set.contains(x1 + "," + y2) && set.contains(x2 + "," + y1)) {
                    tmp = Math.abs(x2 - x1) * Math.abs(y2 - y1);
                    res = Math.min(res, tmp);
                }
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}