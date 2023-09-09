package PG_Level2;

import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;

        Stack<Integer> stk = new Stack<>();
        int now = 1;
        for (int num : order) {
            while (now <= num) {
                stk.add(now);
                now += 1;
            }

            if (stk.peek() == num) {
                stk.pop();
                answer += 1;
            } else
                break;
        }

        return answer;
    }
}