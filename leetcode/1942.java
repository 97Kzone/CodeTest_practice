package leetcode;

import java.util.*;

class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int N = times.length;

        List<int[]> lists = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            lists.add(new int[]{times[i][0], i, 0});
            lists.add(new int[]{times[i][1], i, 1});
        }

        lists.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[2] != b[2]) return b[2] - a[2];
            return a[1] - b[1];  
        });

        TreeSet<Integer> chair = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            chair.add(i);
        }

        int[] check = new int[N];
        int t, idx, type, tmp;
        for (int[] list : lists) {
            t = list[0];
            idx = list[1];
            type = list[2];

            if (type == 1) {
                chair.add(check[idx]);
            } else {
                tmp = chair.first();
                chair.remove(tmp);
                check[idx] = tmp;

                if (idx == targetFriend) {
                    return tmp;
                }
            }
        }

        return -1;
    }
}