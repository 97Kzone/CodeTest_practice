package PG_Level2;

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> wear = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++) {
            wear.put(clothes[i][1], wear.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        for(int val : wear.values()) {
            answer *= (val+1);
        }
        
        return answer - 1;
    }
}