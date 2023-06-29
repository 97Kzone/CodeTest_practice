import java.util.*;


// 1. 시간순으로 정렬
// 2. 다음 과제 전에 끝낼 수 있는가?
//  2-1. Answer에 추가
//  2-2. Stack에서 꺼내서 다음 과제 전까지 수행
// 3. 못 끝낸다면 Stack에 삽입

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        Stack<int[]> stk = new Stack<>();
        
        Arrays.sort(plans, Comparator.comparing(a -> a[1]));
        
        
        int std = 0;
        int res = 0;
        
        for (int i = 0; i < plans.length; i++) {
            String[] plan = plans[i];
            
            int st = time2min(plan[1]);
            int t = Integer.parseInt(plan[2]);
            
            while(!stk.empty()) {
                int[] now = stk.pop();
                
                int et = std + now[1];
                if (et <= st) {
                    answer[res++] = plans[now[0]][0];
                    std += now[1];
                } else {
                    stk.push(new int[] {now[0], now[1] - (st - std)});
                    break;
                }
            }
            stk.push(new int[] {i, t});
            std = st;
        }
        
        while(!stk.empty()) {
            int[] now = stk.pop();
            answer[res++] = plans[now[0]][0];
        }
        return answer;
    }
    
    static int time2min(String s) {
        String[] time = s.split(":");
        
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }
}