// 1. 열쇠를 돌려가면서 구멍 개수를 모두 채우는지 센다
// 2. 구현과 시뮬레이션을 돌려보자
class Solution {

    static int cnt; // 구멍 수
    static int N, M, L;
    static int[][] board;

    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;

        N = lock.length;
        M = key.length;
        L = N + (M * 2) - 2;

        board = new int[L][L];

        for (int i = M - 1; i < M + N - 1; i++) {
            for (int j = M - 1; j < M + N - 1; j++) {
                board[i][j] = lock[i-M+1][j-M+1];
            }
        }

        for (int i = 0; i < 4; i++) {
            if (check(key)) answer = true;
            key = rotate(key);
        }

        return answer;
    }

    static boolean check(int[][] key) {
        for (int i = 0; i < L - M + 1; i++) {
            for (int j = 0; j < L - M + 1; j++) {
                for (int k = 0; k < M; k++) {
                    for (int a = 0; a < M; a++) {
                        board[i + k][j + a] += key[k][a];
                    }
                }

                boolean flag = true;

                for (int k = M - 1; k < M + N - 1; k++) {
                    for (int l = M - 1; l < M + N - 1; l++) {
                        if (board[k][l] != 1) {
                            flag = false;
                            break;
                        }
                    }

                    if (!flag) break;
                }

                if(flag) return true;

                for (int k = 0; k < M; k++) {
                    for (int l = 0; l < M; l++) {
                        board[i + k][j + l] -= key[k][l];
                    }
                }
            }
        }

        return false;
    }

    public static int[][] rotate(int[][] key) {
        int[][] tmp = new int[M][M];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                tmp[i][j] = key[M - j - 1][i];
            }
        }

        return tmp;
    }
}
