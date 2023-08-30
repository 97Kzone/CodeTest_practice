package PG_Level2;

import java.util.*;

class Solution {
    Map<String, Integer> map;
    
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        String[] std;
        String now;
        map = new HashMap<>();
        
        int idx = 0;
        for (String s : skill.split("")) map.put(s, idx++);
        
        boolean flag;
        for (String st : skill_trees) {
            std = st.split("");
            
            idx = 0;
            flag = true;
            for (String s : std) {
                if (!skill.contains(s)) continue;
                
                if (map.get(s) != idx) {
                    flag = false;
                    break;
                }
                idx++;
            }
            
            if (flag) answer++;
        }
        
        return answer;
    }
}
