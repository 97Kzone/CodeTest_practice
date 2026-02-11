package leetcode;

class Solution {

    static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        int res = 1;
        if (a == 1) return res;
        
        a %= MOD;

        for (int num : b) {
            res = pow(res, 10) * pow(a, num) % MOD;
        }

        return res;
    }

    static int pow(int a, int b) {
        int res = 1;
        a %= MOD;

        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * a) % MOD;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }

        return res;
    }
}