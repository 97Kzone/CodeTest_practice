package leetcode;

class Solution {
    public int minimumNumbers(int num, int k) {
        if (num == 0) return 0;

        int target = num % 10;

        for (int i = 1; i <= 10; i++) {
            if ((i * k) % 10 == target && i * k <= num) {
                return i;
            }
        }
        return -1;
    }
}