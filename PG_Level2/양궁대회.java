package PG_Level2;

/**
* 접근법
* 1. 각 점수별 쏜다, 안 쏜다의 조합으로 완전탐색
* 2. 주어진 화살을 다 쐈을 때 스코어 비교
* 3. 최대 점수 차이 갱신 => 정답 갱신
*/

class Solution {
    static int N, res; // 점수 차
    static int[] lion, apeach; // 라이언이 쏜 화살, 어피치가 쏜 화살
    static int[] answer;
    
    public int[] solution(int n, int[] info) {
        N = n;
        apeach = info;
        lion = new int[11];
        answer = new int[]{-1};
        res = -1;
        
        cb(0, n);
        
        return answer;
    }
    
    // 점수 비교
    static int check() {

        int l_score = 0; // 라이언 점수
        int a_score = 0; // 어피치 점수
        
        
        for (int i = 0; i < 11; i++) {    
            // 둘 다 안 맞춘건 계산 X
            if (lion[i] == apeach[i] && lion[i] == 0) continue;
        
            if (lion[i] > apeach[i]) l_score += 10 - i;
            else a_score += 10 - i;
        }
        
        return l_score - a_score;
    }
    
    // 가지를 미리 친 조합
    static void cb(int idx, int cnt) {        
        if (cnt < 0) return; // 남은 화살 수 없으면 끝
        
        if (idx > 10) { // 10점까지 다 쐈으면 비교
            int v = check();
            
            if (v <= 0) return;
            
            // 최대값 갱신
            if (v > res) {
                res = v;
                answer = deepCopy(lion);
                answer[10] += cnt;
            }
            return;
        }
        
        lion[10 - idx] = apeach[10 - idx] + 1; // 딱 1발 더 쏘기
        cb(idx + 1, cnt - lion[10 - idx]);
        lion[10 - idx] = 0; // 해당 점수 포기
        cb(idx + 1, cnt);
    }
    
    static int[] deepCopy(int[] arr) {
        int[] res = new int[11];
        for (int i = 0; i < 11; i++) res[i] = arr[i];
        return res;
    }
}