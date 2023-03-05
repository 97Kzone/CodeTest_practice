import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_2115_2 {
    static int N, M, C, res;
    static int[][] board, pBoard;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            board = new int[N][N];
            pBoard = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            res = 0;
            setBoard();
            check();

            sb.append("#" + t + " ").append(res + "\n");
        }
        System.out.print(sb.toString());
    }

    // 벌통 고르기
    static void check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                
                // 같은 행일 때
                for (int k = j + M; k < N - M + 1; k++) {
                    res = Math.max(res, pBoard[i][j] + pBoard[i][k]);
                }

                // 다른 행일 때
                for (int a = i + 1; a < N; a++) {
                    for (int b = 0; b < N - M + 1; b++) {
                        res = Math.max(res, pBoard[i][j] + pBoard[a][b]);
                    }
                }   

            }
        }
    }

    static void setBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - M + 1; j++) {
                setMaxValue(i, j, 0, 0, 0); // 좌표, idx, C값, 벌꿀채취량
            }
        }
    }

    static void setMaxValue(int i, int j, int idx, int cSum, int pSum) {
        if (cSum > C) return;
        if (idx == M) {
            pBoard[i][j - M] = Math.max(pBoard[i][j - M], pSum);
            return; 
        }

        setMaxValue(i, j + 1, idx + 1, cSum, pSum);
        setMaxValue(i, j + 1, idx + 1, cSum + board[i][j], pSum + board[i][j] * board[i][j]);
    }
}
