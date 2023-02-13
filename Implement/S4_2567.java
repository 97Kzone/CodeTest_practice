package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_2567 {
    static int N;
    static int[][] board;
    static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[101][101];

        int x, y;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            for (int a = x; a < x + 10; a++) {
                for (int b = y; b < y + 10; b++) {
                    board[a][b] = 1;
                }
            }
        }

        // 0 이 근처에 있으면 테두리
        int nx, ny;
        int res = 0;
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (board[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        nx = i + moves[k][0];
                        ny = j + moves[k][1];

                        // 모서리는 0이 2개 => 0 찾아도 마저 사방 탐색..
                        if (nx >= 0 && ny >= 0 && nx < 101 && ny < 101) {
                            if (board[nx][ny] == 0) {
                                res++;
                            }
                        } else {
                            res++;
                        }
                    } 
                }
            }
        }
        System.out.print(res);
    }
}
