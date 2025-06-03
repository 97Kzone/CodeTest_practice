package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_2799 {

    static int N, M;
    static int[] cnt;
    static char[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new char[5*M+1][5*N+1];
        for (int i = 0; i < 5 * M + 1; i++) {
            board[i] = br.readLine().toCharArray();
        }

        cnt = new int[5];
        int v, nx;
        for (int i = 1; i < 5*M+1; i += 5) {
            for (int j = 1; j < 5*N+1; j += 5) {
                v = 0;
                if(board[i][j] == '.') {
                    cnt[v]++;
                    continue;
                }

                if (board[i][j] == '*') {
                    v++;
                    nx = i+1;
                    while(true) {
                        if(board[nx][j] == '.' || board[nx][j] == '#' ) {
                            cnt[v]++;
                            break; 
                        }

                        v++;
                        nx++;
                    }
                }
            }
        }

        for (int n : cnt ) sb.append(n + " ");

        System.out.print(sb.toString());
    }
}
