package PG_Level2;

import java.util.*;

class Solution {
    
    static String[] chars = {"A", "E", "I", "O", "U"};
    static String[] pick = new String[5];
    static ArrayList<String> words = new ArrayList<>();
    
    public int solution(String word) {
        int answer = 0;
        words.clear();
        
        for (int i = 1; i <= 5; i++) pm(0, i);
        
        Collections.sort(words);
        
        return words.indexOf(word) + 1;
    }
    
    static void pm(int cnt, int idx) {
        if (cnt == idx) {
            String s = "";
            
            for (int i = 0; i < idx; i++) s += pick[i];
            words.add(s);
            
            return;
        }
        
        for (int i = 0; i < 5; i++) {
            pick[cnt] = chars[i];
            pm(cnt + 1, idx);
        }
    }
}