package PG_Level2;

import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] temp = s.split(" ");
        int[] num = new int[temp.length];
        
        for(int i = 0; i < temp.length; i++) {
            num[i] = Integer.parseInt(temp[i]);
        }
        
        Arrays.sort(num);
        answer = num[0] + " " + num[num.length-1];
        
        return answer;
    }
}
