package PG_Level1;

import java.util.*;

/*
* 접근법
* 1. 0 은 확정 정답/오답이 가능하다
* 2. 읽을 수 있는 수 중 일치하는것만 카운팅해도 될 듯
* 3. 일치하는 개수와 등수를 잘 보자
*/

class 로또의최고최저순위 {
    static int cand, corr; // 0 개수, 일치하는 수
    static List<Integer> winNum; // 쉽게 조회하기 위해 리스트로 변경
    
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        // 1. Array -> List 무식.ver
        winNum = new ArrayList<>();
        for (int n : win_nums) winNum.add(n);
      
        cand = 0;
        corr = 0;
        // 2. 0 , 일치하는 수 카운팅 
        for (int n : lottos) {
            if (n == 0) {
                cand++;
                continue;
            }
            
            if (winNum.contains(n)) corr++;
        }
        
        // 최고 : 7 - (0 개수 + 맞춘 수)
        // 최악 : 7 - (맞춘 수)
        int v = 7 - (corr + cand);
        answer[0] = v == 0 ? 1 : v;
        answer[0] = v == 7 ? 6 : v; // 테스트 14 위한 조건
        
        v = 7 - corr;
        answer[1] = v == 7 ? 6 : v;
        return answer;
    }
}