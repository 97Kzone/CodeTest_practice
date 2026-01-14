package leetcode;

class Solution {
    public String getSmallestString(int n, int k) {
        char[] arr = new char[n];

        for (int i = 0; i < n; i++) {
            arr[i] = 'a';
        }

        int std = k - n; 
        int v;
        for (int i = n - 1; i >= 0 && std > 0; i--) {
            v = Math.min(25, std);
            arr[i] = (char) (arr[i] + v);
            std -= v;
        }

        return new String(arr);
    }
}
