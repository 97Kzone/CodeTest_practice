package PG_Level1;

import java.util.*;

class Solution {
    
    public int solution(String[] babbling) {
        int answer = 0;
        
        int len;
        for (String word : babbling) {
            len = word.length();
            
            // 1. 연속 옹알이 체크
            word = word.replaceAll("woowoo", "")
                       .replaceAll("ayaaya", "")
                       .replaceAll("yeye", "")
                       .replaceAll("mama", "");
            
            if (word.length() != len) continue;
            
            // 2. 가능성 체크
            word = word.replaceAll("woo", " ")
                       .replaceAll("aya", " ")
                       .replaceAll("ye", " ")
                       .replaceAll("ma", " ")
                       .replaceAll(" ", "");
            
            if ("".equals(word)) answer++;
        }
        
        
        return answer;
    }
}