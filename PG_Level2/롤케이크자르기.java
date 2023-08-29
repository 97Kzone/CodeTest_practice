package PG_Level2;

import java.util.*;

class Solution {
    
    static Map<Integer, Integer> map1, map2; // 형, 동생
    
    public int solution(int[] topping) {
        int answer = 0;
        map1 = new HashMap<>();
        map2 = new HashMap<>();
        
        // 1. 초기 설정
        for (int n : topping) map2.put(n, map2.getOrDefault(n, 0) + 1);    
        
        // 2. 한개씩 뺏어보자
        for (int n : topping) {
            map1.put(n, map1.getOrDefault(n, 0) + 1); // 뺏어오고
            map2.put(n, map2.getOrDefault(n, 1) - 1); // 뺏기고
            
            if (map2.get(n) == 0) map2.remove(n);
            
            if (map1.size() == map2.size()) answer++;
        }
    
        return answer;
    }
}