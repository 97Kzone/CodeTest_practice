package PG_Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    static Map<String, Integer> cand; // 메뉴 후보군 
    static List<String> answer; // 당선된 메뉴들
    
    public String[] solution(String[] orders, int[] course) {
        
        char[] word;
        cand = new HashMap<>();
        answer = new ArrayList<>();
        
        for (int n : course) {
            for (String order : orders) {
                word = order.toCharArray();
                Arrays.sort(word);
                
                if (n <= word.length) cb(word, 0, n, 0, "");
            }
            
            if (!cand.isEmpty()) {
                check();
                cand.clear();
            }
        }     
        
        Collections.sort(answer);
        
        String[] res = new String[answer.size()];
        for (int i = 0; i < answer.size(); i++) res[i] = answer.get(i);
        return res;
    }
    
    // 조합
    static void cb(char[] word, int cnt, int num, int idx, String select) {
        if (cnt == num) { // 기저조건
            int v = cand.getOrDefault(select, 0);
            cand.put(select, v + 1);
            return;
        }
        
        for (int i = idx; i < word.length; i++) {
            cb(word, cnt + 1, num, i + 1, select + word[i]);
        }
    }
    
    static void check() {
        List<Integer> count = new ArrayList<>(cand.values());
        int max = Collections.max(count);
        
        if (max >= 2) {
            for (String key : cand.keySet()) {
                if (cand.get(key) == max) {
                    answer.add(key);
                }
            }
        }
    }
}