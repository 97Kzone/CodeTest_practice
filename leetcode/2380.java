package leetcode;

class Solution {
    public int secondsToRemoveOccurrences(String s) {
        int cnt = 0;
        int res = 0;

        for (char c : s.toCharArray()) {
            if (c == '0') {
                cnt++;
            } else { 
                if (cnt > 0) {
                    res = Math.max(res + 1, cnt);
                }
            }
        }
        return res;
    }
}
