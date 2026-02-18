package leetcode;

class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        int N = s.length();

        int res = 1;
        int cnt = 0;
        int idx = 0;

        for (int i = 1; i < N; i++) {
            if (s.charAt(i) == s.charAt(i-1)) cnt++;

            while(cnt > 1) {
                if (idx + 1 < N && s.charAt(idx) == s.charAt(idx + 1)) cnt--;
                idx++;
            }

            res = Math.max(res, i - idx + 1);
        }

        return res;
    }
}