package PG_Level1;

import java.util.*;

/**
 *
 * 겉은 어려워 보이는 문제
 * 1. moves 배열이 순서와 위치도 정해준다
 * 2. moves 배열 위치에 인형이 있는지 판단
 * 3. 문제가 자료구조도 친절히 설명해준다
 * => 구현해보자
 */
class 크레인인형뽑기게임 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int move : moves) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][move - 1] == 0)
                    continue;

                if (stack.isEmpty()) {
                    stack.push(board[j][move - 1]);
                    board[j][move - 1] = 0;
                    break;
                }

                if (board[j][move - 1] == stack.peek()) {
                    stack.pop();
                    answer += 2;
                } else
                    stack.push(board[j][move - 1]);

                board[j][move - 1] = 0;
                break;
            }
        }
        return answer;
    }
}