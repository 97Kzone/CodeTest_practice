package PG_Level1;

import java.util.*;

class Solution {
    public int[] solution(String s) {
        Map<Character, Integer> cnt = new HashMap<>();
        int N = s.length();
        int[] answer = new int[N];
        
        char c;
        int idx;
        for (int i = 0; i < N; i++) {
            c = s.charAt(i);
            idx = cnt.getOrDefault(c, -1);
            
            if (idx == -1) answer[i] = -1;
            else answer[i] = i - idx;
            cnt.put(c, i);
        }
        
        return answer;
    }
}