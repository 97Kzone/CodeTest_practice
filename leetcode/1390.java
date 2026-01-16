package leetcode;

class Solution {
    public int sumFourDivisors(int[] nums) {
        int res = 0;

        for (int num : nums) {
            res += check(num);
        }

        return res;
    }

    private int check(int num) {
        int p = (int) Math.round(Math.cbrt(num));
        if ((long) p * p * p == num && isPrime(p)) {
            return 1 + p + p * p + num;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                int j = num / i;
                if (i != j && isPrime(i) && isPrime(j)) {
                    return 1 + i + j + num;
                }
                return 0; 
            }
        }

        return 0;
    }

    private boolean isPrime(int x) {
        if (x < 2) return false;
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }
}
