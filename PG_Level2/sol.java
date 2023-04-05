package PG_Level2;

import java.util.Arrays;

public class sol {
    public static void main(String[] args) {
    }    
}

class Solution {
    static char[] word;
    public String[] solution(String[] orders, int[] course) {
        for (String order : orders) {
            word = order.toCharArray();
            Arrays.sort(word);
            
            for (int n : course) {
                cb(n);
            }
        }
        
        return null;
    }

    static String cb(int idx) {
        return null;
    }
}

