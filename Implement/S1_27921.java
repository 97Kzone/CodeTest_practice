package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_27921 {

    static int h1, w1, h2, w2;
    static char[][] board1, board2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        h1 = Integer.parseInt(st.nextToken());
        w1 = Integer.parseInt(st.nextToken());
        board1 = new char[h1][w1];

        int std = 0;
        for (int i = 0; i < h1; i++) {
            board1[i] = br.readLine().toCharArray();
            for (int j = 0; j < w1; j++) {
                std += board1[i][j] == 'O' ? 1 : 0;
            }
        }

        st = new StringTokenizer(br.readLine());
        h2 = Integer.parseInt(st.nextToken());
        w2 = Integer.parseInt(st.nextToken());
        board2 = new char[h2 + h1 * 2][w2 + w1 * 2];

        String s;
        for (int i = h1; i < h1 + h2; i++) {
            s = br.readLine();
            for (int j = w1; j < w1 + w2; j++) {
                board2[i][j] = s.charAt(j-w1);
            }
        }

        int res = 0;
        int cnt;
        for (int i = 0; i < h1 + h2; i++) {
            for (int j = 0; j < w1 + w2; j++) {
                cnt = 0;
                for (int k = 0; k < h1; k++) {
                    for (int l = 0; l < w1; l++) {
                        if (board1[k][l] == 'O' && board2[i + k][j + l] == 'O')
                            cnt++;
                    }
                }

                res = Math.max(cnt, res);
            }
        }
        System.out.print(std - res);
    }
}
