package PG_Level1;

import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        TreeSet<Integer> res = new TreeSet<>();
        
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                res.add(numbers[i] + numbers[j]);   
            }
        }
        

        int[] answer = new int[res.size()];
        int idx = 0;
        for (int num : res) {
            answer[idx++] = num;
        }
        return answer;
    }
}