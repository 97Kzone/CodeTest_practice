package PG_Level2;

import java.util.*;

class Solution {
    
    static Map<Integer, Integer> map;
    
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        map = new HashMap<>();
        
        for (int v : tangerine) {
            map.put(v, map.getOrDefault(v, 0) + 1);
        }
        
        List<Map.Entry<Integer, Integer>> entry = new LinkedList<>(map.entrySet());
        entry.sort(((o1, o2) -> map.get(o2.getKey()) - map.get(o1.getKey())));
        
        int std = 0;
        for(Map.Entry<Integer, Integer> e : entry){
            std += e.getValue();
            answer++;
            if (std >= k) break; 
        }
        return answer;
    }
}
