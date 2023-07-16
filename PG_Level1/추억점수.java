package PG_Level1;

import java.util.*;

class Solution {
    
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int N = name.length;
        int[] answer = new int[photo.length];
        Map<String, Integer> map = new HashMap<>();
        
        // Map을 쓰자
        int idx = 0;
        for (int i = 0; i < N; i++) map.put(name[i], yearning[i]);
        
        int res = 0;
        for (String[] p : photo) {
            res = 0;
            
            for (String n : p) res += map.getOrDefault(n, 0);
            answer[idx++] = res;
        }
        return answer;
    }
}