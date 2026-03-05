package leetcode;

class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int ans = Integer.MIN_VALUE;

        int sum;
        int best;
        for (int r = 0; r < k; r++) {
            int last = r + ((n - 1 - r) / k) * k;

            sum = 0;
            best = Integer.MIN_VALUE;

            for (int i = last; i >= 0; i -= k) {
                sum += energy[i];
                if (sum > best) best = sum;
            }

            if (best > ans) ans = best;
        }

        return ans;
    }
}
