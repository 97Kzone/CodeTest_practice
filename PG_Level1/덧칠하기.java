package PG_Level1;

import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        // 초기 세팅
        int[] board = new int[n];
        Arrays.fill(board, 1);
        for (int v : section) board[v-1] = 0;
        
        for (int i = 0; i < n ; i++) {
            if (board[i] == 0) {
                for (int j = 0; j < m; j++) {
                    if(i + j >= n) break;
                    board[i+j] = 1;
                }
                answer++;
            }    
        }
        
        return answer;
    }
}
