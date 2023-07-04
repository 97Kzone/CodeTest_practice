package PG_Level2;

import java.util.*;

// 틱태토 규칙이 지켜지려면
// 1. 선공이 O, 따라서 O가 최대 1개 더 많을 수 있다
// 2. 가로 세로 완성된 O, X 가 공존할 수 없다
class Solution {

    static boolean flag1, flag2;
    static int cnt1, cnt2;

    public int solution(String[] board) {
        cnt1 = 0;
        cnt2 = 0;

        // 1. O, X 개수 체크
        for (String s : board) {
            for (int i = 0; i < 3; i++) {
                if (s.charAt(i) == 'O') cnt1++;
                else if (s.charAt(i) == 'X') cnt2++;
            }
        }

        int diff = cnt1 - cnt2;
        if (diff != 0 && diff != 1) return 0;

        // 2. 가로 빙고 체크
        for (String s : board) {
            if (s.charAt(0) == s.charAt(1) && s.charAt(1) == s.charAt(2)) {
                if (s.charAt(0) == 'O') flag1 = true;
                else if (s.charAt(0) == 'X') flag2 = true;
            }
        }


        // 3. 세로 빙고 체크
        for (int i = 0; i < 3; i++) {
            if(board[0].charAt(i) == board[1].charAt(i) 
               && board[1].charAt(i) == board[2].charAt(i)) {
                if (board[0].charAt(i) == 'O') flag1 = true;
                else if (board[0].charAt(i) == 'X') flag2 = true;
            }

        }

        // 4. 대각선 체크
        if (board[0].charAt(0) == board[1].charAt(1) &&
            board[1].charAt(1) == board[2].charAt(2)) {
            if (board[0].charAt(0) == 'O') flag1 = true;
            else if(board[0].charAt(0) == 'X') flag2 = true;
        }

        if (board[0].charAt(2) == board[1].charAt(1) &&
            board[1].charAt(1) == board[2].charAt(0)) {
            if (board[0].charAt(2) == 'O') flag1 = true;
            else if(board[0].charAt(2) == 'X') flag2 = true;
        }


        if (!check()) return 0;

        return 1;
    }

    static boolean check() {
        if (flag1) if (cnt1 - cnt2 != 1) return false;
        if (flag2) if (cnt1 != cnt2) return false;
        if (flag1 && flag2) return false;

        return true;
    }
}