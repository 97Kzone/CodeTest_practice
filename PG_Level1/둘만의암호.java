package PG_Level1;

import java.util.*;

class Solution {
    
    static Set<Character> set; // 밴 리스트
    
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        set = new HashSet<>();
        
        // 1. 벤 리스트 추가
        for (int i = 0; i < skip.length(); i++) {
            set.add(skip.charAt(i));
        }
        
        // 2. 단어
        int a, cnt;
        for (int i = 0; i < s.length(); i++) {
            a = s.charAt(i) - 'a';
            cnt = 0;
            
            while (cnt != index) {
                a = (a + 1) % 26;
                if (set.contains((char) (a + 97))) continue;
                cnt++;
            }
            
            answer += (char) (a + 97);
        }
        
        return answer;
    }
}
