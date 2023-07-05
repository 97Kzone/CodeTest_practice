package PG_Level2;

import java.util.*;

class Solution {
    static int N;
    
    public int[] solution(int[] numbers) {
        N = numbers.length;
        int[] answer = new int[N];
        Arrays.fill(answer, -1);
        
        Stack<Integer> stk = new Stack<>();
        
        for (int i = 0; i < N; i++) {
            while(!stk.isEmpty() && numbers[stk.peek()] < numbers[i]) {
                answer[stk.pop()] = numbers[i];
            }
            stk.add(i);
        }

        return answer;
    }
}
