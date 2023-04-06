package PG_Level2;

import java.util.*;

/*
* 접근법
* 1. 각 작업이 걸리는 시간을 구할 수 있는가 ? => O(N) 으로 가능
* 2. 앞선 작업이 끝나야 현재 작업 배포 가능 => 익숙한 제한 조건
* 3. 큐로 풀어 나가보자
*/

class 기능개발 {
    static List<Integer> res;
    static Queue<Integer> q;
    
    public int[] solution(int[] progresses, int[] speeds) {
        q = new ArrayDeque<>();
        res = new ArrayList<>();
        int size = progresses.length;
        
        for (int i = 0; i < size; i++) {
            int tmp = ((100 - progresses[i]) / speeds[i]);
            tmp = (100 - progresses[i]) % speeds[i] != 0 ? tmp + 1 : tmp;
            q.offer(tmp);
        }
        
        
        check();
        int[] answer = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }
        
        return answer;
    }
    // 배포 체크
    static void check() {
        int std = q.poll();
        int cnt = 1;
        while (!q.isEmpty()) {
            if (std >= q.peek()) {
                q.poll();
                cnt++;
            } else {
                std = q.poll();
                res.add(cnt);
                cnt = 1;
            }
        }
        res.add(cnt);
    }
}