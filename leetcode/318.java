package leetcode;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maxProduct(String[] words) {
        int res = 0;
        int N = words.length;
        Set<Character> set;


        boolean flag;
        for (int i = 0; i < N; i++) {
            set = new HashSet<>();
            for (char c : words[i].toCharArray()) {
                set.add(c);
            }

            for (int j = i + 1; j < N;j ++) {
                flag = true;

                for (char c : words[j].toCharArray()) {
                    if (set.contains(c)) {
                        flag = false;
                        break;
                    }
                }
            
                if (flag) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }

        return res;
    }
}
