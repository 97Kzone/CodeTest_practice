package leetcode;

import java.util.*;

class Solution {

    static final int MOD = 1_000_000_007;
    public int maxProfit(int[] inventory, int orders) {
        int N = inventory.length;
        long res = 0;
        long cnt = 1; 
        Arrays.sort(inventory);
        
        int cur, nxt;
        long diff, tmp, div, mod;
        for (int i = N - 1; i >= 0 && orders > 0; i--) {
            cur = inventory[i];
            nxt = (i > 0) ? inventory[i - 1] : 0;

            diff = cur - nxt;          
            tmp = diff * cnt;          

            if (orders >= tmp) {
                res = (res + cnt * check(nxt + 1, cur)) % MOD;
                orders -= tmp;
            } else {
                div = orders / cnt;  
                mod  = orders % cnt;

                int low = cur - (int) div;   
                res = (res + cnt * check(low + 1, cur)) % MOD;
                res = (res + mod * (long)low) % MOD;

                orders = 0;
            }

            cnt++; 
        }

        return (int) res;
    }

    private long check(long a, long b) {
        long terms = b - a + 1;
        return (a + b) * terms / 2;
    }
}