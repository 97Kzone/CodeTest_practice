package leetcode;

import java.util.*;

class Solution {
    public int maximumTastiness(int[] price, int k) {
        int N = price.length;
        Arrays.sort(price);
    
        int l = 0;
        int r = price[N - 1] - price[0];
        int res = 0;

        int m;
        while(l <= r) {
            m = l + (r - l) / 2;

            if (isPossible(price, k, m)) {
                res = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }        

        return res;
    }

    static boolean isPossible(int[] price, int k, int mid) {
        int cnt = 1;
        int std = price[0];

        for (int i = 1; i < price.length; i++) {
            if (price[i] - std >= mid) {
                cnt++;
                std = price[i];
            }

            if (cnt == k) {
                return true;
            }
        }

        return cnt >= k;
    }
}
