import java.util.*;

class Solution {
    
    static List<int[]> board;
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        int cnt = picks[0] + picks[1] + picks[2];
        int N = Math.min(cnt * 5, minerals.length);
        
        board = new ArrayList<>();
        
        int[] std = new int[3]; // 각각 다이아, 철, 돌로 캤을 때 피로도
        for (int i = 0; i < N ; i++) {
            if (i != 0 && i % 5 == 0) {
                board.add(std);
                std = new int[3];
            }
            
            if ("diamond".equals(minerals[i])) {
                std[0]++;
                std[1] += 5;
                std[2] += 25;
            } else if ("iron".equals(minerals[i])) {
                std[0]++;
                std[1]++;
                std[2] += 5;
            } else {
                std[0]++;
                std[1]++;
                std[2]++;
            }
        }
        
        board.add(std); // 잔반처리
        
        // 총 합 높은 순 정렬 => 다이아가 캐야한다
        Collections.sort(board, (o1, o2) -> ((o2[0] + o2[1] + o2[2]) - (o1[0] + o1[1] + o1[2])));
        
        // 캐기 시작
        for (int[] val : board) {
            if (picks[0] > 0) {
                answer += val[0];
                picks[0]--;
            } else if (picks[1] > 0) {
                answer += val[1];
                picks[1]--;
            } else {
                answer += val[2];
                picks[2]--;
            }
        }
        
        return answer;
    }
}