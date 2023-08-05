package PG_Level1;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        
        int[] xCnt = new int[10];
        int[] yCnt = new int[10];
    
        for (int i = 0; i < X.length(); i++) {
            xCnt[X.charAt(i) - '0']++;
        }
        
        for (int i = 0; i < Y.length(); i++) {
            yCnt[Y.charAt(i) - '0']++;
        }

        for (int i = 9; i >= 0; i--) {
            int cnt;
            if (xCnt[i] != 0 && yCnt[i] != 0) {
                cnt = Math.min(xCnt[i], yCnt[i]);
                answer += String.valueOf(i).repeat(cnt);
            }
        }

        answer = "".equals(answer) ? "-1" : answer;
        if (answer.charAt(0) == '0') answer = "0";
        return answer;
    }
}