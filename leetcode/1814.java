package leetcode;

class Solution {

    private static int MOD = 1_000_000_007;

    public int countNicePairs(int[] nums) {
        Map<Long, Long> cnt = new HashMap<>();

        long res = 0;

        long k, v;
        for (int num : nums) {
            k = num - check(num);
            v = cnt.getOrDefault(k, 0L);

            res = (res + v) % MOD;
            cnt.put(k, v + 1);
        }    

        return (int) res;
    }

    static int check(int num) {
        int res = 0;
        while (num > 0) {
            res = res * 10 + (num % 10);
            num /= 10;
        }

        return res;
    }
}