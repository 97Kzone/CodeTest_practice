package PG_Level2;

import java.util.HashMap;
import java.util.*;

class Solution {
    public int[] solution(String msg) {
        HashMap<String, Integer> std = new HashMap<String, Integer>();
        StringBuilder sb = new StringBuilder();
        int start = 0;       
        for(int i = 1; i <= 26; i++) // 사전 초기화
        {
            int AtoZ = 64;
            AtoZ += i;
            char temp = (char)start;
            std.put(String.valueOf(temp), i);
        }

        for(int i = 1; i < msg.length(); i++) 
        {                
            int end = find(std, msg, start);
            String now = msg.substring(start, end);
            String next = now + "" + msg.substring(end, end+1);
        }

        
       
        int[] answer = {};
        return answer;
    }
    public static int find(HashMap std, String msg, int start)
    {
        String[] value = std.values();
        int cnt = 0;
        for(int i = start+1; i < msg.length(); i++)
        {
            String temp = msg.substring(start, i);
            if(std.get(temp) != null)
            {
                cnt++;
                continue;
            }
            else if(std.get(temp) == null)
            {
                std.add(value[value.length-1] + 1);
                return cnt;
            }                
        }
        return cnt;
    }
    
}
