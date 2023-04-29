import java.util.*;

/*
* 접근법 
* 1. 시간을 min 단위로 변경, 우선순위 큐에 전부 삽입
* 2. 막차가 될 때 까지, 큐를 비운다
* 3. 막차일 때, 가장 마지막에 타는 사람보다 1분 빨리 도착하면 OK
*/

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        
        // 1. 분 단위로 변경, 큐에 삽입
        PriorityQueue<Integer> q = new PriorityQueue();
        for (String time : timetable) {
            q.offer(str2min(time));
        }
        
        // 2. 막차가 도착한 시간, 전체 탈 수 있는 인원
        int last = 540 + (t * (n-1));
        int cnt = m * n;
        
        // 전체 탈 수 있는 인원 > 대기열 인원 => 따질게 없다
        if (cnt > timetable.length) return  min2str(last);
        
        // 막차 타는 사람이 나올 때 까지 차 타기
        while (cnt > 1) {
            
            if (q.isEmpty()) return min2str(last);
            // 막차보다 늦게 도착하는 사람이 있으면 break
            if (q.peek() <= last) q.poll();
            else return min2str(last);
        } 
        
        
        return answer;
    }
    
    public int str2min(String s) {
        String[] time = s.split(":");
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }
    
    public String min2str(int time) {
        int h = time / 60;
        int m = time % 60;
        
        return String.format("%02d", h) + ":" + String.format("%02d", m);
    }
}