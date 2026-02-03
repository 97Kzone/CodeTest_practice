package leetcode;

class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> map = new HashMap<>();

        int[] cnt = new int[26];
        int v = 0;
        int l = 0;

        for (int i = 0; i < s.length(); i++) {
            int r = s.charAt(i) - 'a';
            if (cnt[r] == 0) v++;
            cnt[r]++;

            if (i - l + 1 > minSize) {
                int c = s.charAt(l) - 'a';
                cnt[c]--;
                if (cnt[c] == 0) v--;
                l++;
            }

            if (i - l + 1 == minSize && v <= maxLetters) {
                String sub = s.substring(l, i + 1);
                map.put(sub, map.getOrDefault(sub, 0) + 1);
            }
        }

        int res = 0;
        for (int val : map.values()) {
            res = Math.max(res, val);
        }
        return res;
    }
}