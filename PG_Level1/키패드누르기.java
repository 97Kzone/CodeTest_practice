package PG_Level1;

import java.util.*;

// 키패드 거리는 맨해튼 거리

/*
* 접근법
* 1. 왼손, 오른손의 현재위치를 좌표로 메모
* 2. 2, 5, 8, 0 을 마주하면 거리 계산
* 3. O(1) 접근을 위한 Map 사용
*/
class Solution {
    static Map<Integer, String> map; // 왼, 오 매핑
    static Map<Integer, int[]> map2; // 좌표 매핑
    static int[] l, r;
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        String s = "";
        init();    
        
        int ld, rd;
        for (int num : numbers) {
            if (num == 2 || num == 5 || num == 8 || num == 0) {
                ld = checkDist(l, map2.get(num));
                rd = checkDist(r, map2.get(num));
                
                if (ld == rd) { // 거리가 같으면 무슨 손잡이 인지 따진다
                    if (hand.equals("left")) {
                        answer += "L";
                        l = map2.get(num);
                    } else {
                        answer += "R";
                        r = map2.get(num);
                    }
                } else if (ld < rd) { // 왼손이 더 가깝다
                    answer += "L";
                    l = map2.get(num);
                } else { // 오른손이 더 가깝다
                    answer += "R";
                    r = map2.get(num);
                }
            } else {
                s = map.get(num);
                answer += s;
                if (s == "L") l = map2.get(num);
                else r = map2.get(num);
                
            }
        }
        
        return answer;
    }
    
    // 거리계산
    static int checkDist(int[] std, int[] tar) {
        return Math.abs(std[0] - tar[0]) + Math.abs(std[1] - tar[1]);
    }
    
    
    // Map 생성, 초기 좌표 설정
    static void init() {
        map = new HashMap<>();
        map2 = new HashMap<>();
        
        for (int i = 1; i < 8; i += 3) map.put(i, "L");
        for (int i = 3; i < 10; i += 3) map.put(i, "R");
    
        map2.put(0, new int[] {3, 1});
        int idx = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map2.put(idx++, new int[] {i, j});
            }
        }
        
        l = new int[] {3, 0};
        r = new int[] {3, 2};
        
    }
}