package PG_Level2;

import java.util.*;

class Solution {
    
    static int[] time;
    
    public int solution(String[][] book_time) {
        int answer = 0;
        int start, end;

        time = new int[1451]; // 매 분을 다 체크 해보자
        
        for (String[] s : book_time) {
            start = str2min(s[0]);
            end = str2min(s[1]);
            
            time[start]++;
            time[end + 10]--;
        }
        
        for (int i = 1; i <= 1440; i++) {
            time[i] += time[i-1];
            answer = Math.max(answer, time[i]);
        }
        
        return answer;
    }

    static int str2min(String s) {
        String[] time = s.split(":");
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }
    
}
