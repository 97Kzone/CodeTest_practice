import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = 0;
        
        // 2번의 탐색
        Stack<Integer> stk = new Stack<>();
        stk.add(a[0]);
        
        for (int i = 1; i < a.length; i++) {
            if (stk.peek() < a[i]) continue;
            
            stk.add(a[i]);
        }       
        
        answer += stk.size();
        
        stk.clear();
        stk.add(a[a.length - 1]);
        
        for (int i = a.length - 2; i >= 0; i--) {
            if (stk.peek() < a[i]) continue;
            
            stk.add(a[i]);
        }
        
        answer += stk.size();
        
        return answer - 1;
    }
}