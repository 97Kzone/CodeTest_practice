package PG_Level2;

import java.util.*;

/*
* 접근법
* 1. 문제를 잘 읽어본다
* 2. 어라? 많이 본 패턴과 유형이다
* 3. 스택을 이용하여 왔다 갔다 해보자
*/
class Solution {
    
    static Stack<int[]> deli, pick;
    
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        deli = new Stack<>();
        pick = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            if (deliveries[i] != 0) deli.add(new int[] {i+1, deliveries[i]});
            if (pickups[i] != 0) pick.add(new int[] {i+1, pickups[i]});
        }
        
        // 배달과 수거가 다 진행 될 때 까지 반복
        int v1, v2;
        while (!deli.isEmpty() || !pick.isEmpty()) {
            v1 = deli.isEmpty() ? 0 : deli.peek()[0];
            v2 = pick.isEmpty() ? 0 : pick.peek()[0];
            answer += Math.max(v1, v2);
            
            int std = cap;
            int[] now;
            while (std > 0 && !deli.isEmpty()) {
                now = deli.pop();
                if (now[1] <= std) std -= now[1];
                else {
                    now[1] -= std;
                    deli.add(now);
                    break;
                } 
            }
            
            std = cap;
            while (std > 0 && !pick.isEmpty()) {
                now = pick.pop();
                if (now[1] <= std) std -= now[1];
                else {
                    now[1] -= std;
                    pick.add(now);
                    break;
                }
            }
        }
        
        return answer * 2;
   
    }
}