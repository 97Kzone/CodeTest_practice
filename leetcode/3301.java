package leetcode;

import java.util.*;

class Solution {
    public long maximumTotalSum(int[] maximumHeight) {
        int N = maximumHeight.length;
        Arrays.sort(maximumHeight); 

        int tmp;
        for (int i = 0, j = N - 1; i < j; i++, j--) {
            tmp = maximumHeight[i];
            maximumHeight[i] = maximumHeight[j];
            maximumHeight[j] = tmp;
        }

        long res = maximumHeight[0];
        for (int i = 1; i < N; i++) {
            // impossible
            if (maximumHeight[i-1] == 1) {
                res = -1;
                break;
            }

            if (maximumHeight[i] >= maximumHeight[i - 1]) {
                maximumHeight[i] = maximumHeight[i - 1] - 1;
            } 
            res += maximumHeight[i];
        }

        return res;
    }
}
