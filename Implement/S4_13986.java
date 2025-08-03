package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S4_13986 {

    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        boolean flag;
        while(true) {
            flag = false;

            for (int i = N - 1; i > 0; i--) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] != '.') continue;
    
                    if (board[i-1][j] == 'o') {
                        board[i][j] = 'o';
                        board[i-1][j] = '.';
                        flag = true;
                    }
                }
            } 

            if (!flag) break;
        }

        for (char[] ch : board) {
            for (char c : ch) {
                bw.write(c);
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
