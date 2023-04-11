package PG_Level2;

import java.util.*;

/*
 * 접근법
 * 1. 주차 요금은 "차량번호" 를 기준 정산
 * 2. 출력은 "낮은번호" 순으로 출력
 * 3. TreeMap 으로 순서를 보장하고, HashMap 으로 누적시간을 계산해보자
 */

class 주차요금계산 {
    static Map<String, Integer> cost;
    static Map<String, Integer> status;
    
    public int[] solution(int[] fees, String[] records) {
        cost = new TreeMap<>();
        status = new HashMap<>();

        String[] s;
        int time, v;
        for (String record : records) {
            s = record.split(" ");
            time = hourToMin(s[0]);
            
            // 입차
            if ("IN".equals(s[2])) status.put(s[1], time);
            // 출차 => 시간 정산 + Map 에서 제거
            else {
                v = time - status.get(s[1]); // 시간차
                
                int tmp = cost.getOrDefault(s[1], 0);
                cost.put(s[1], tmp + v);
                
                status.remove(s[1]);
            }
        }
        
        // 입차만 하고 출차 안한 차들 정산
        for (String k : status.keySet()) {
            time = 1439 - status.get(k);
            v = cost.getOrDefault(k, 0);
            
            cost.put(k, v + time);
        }
        
        int[] answer = new int[cost.size()];
        
        // 요금 정산
        int idx = 0;
        for (String k : cost.keySet()) {
            time = cost.get(k); // 누적시간
            
            // 기본시간 이하라면 기본요금
            if (time <= fees[0]) { 
                answer[idx++] = fees[1];
                continue;
            }
            
            time -= fees[0]; // 초과시간
            v = (int) Math.ceil((double) time / fees[2]) * fees[3]; // 초과요금
            answer[idx++] = fees[1] + v; // 기본요금 + 초과요금
        }    
    
        return answer;
    }
    
    // 시간 -> 분
    static int hourToMin(String s) {
        String[] tmp = s.split(":");
        return Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);
    }
}