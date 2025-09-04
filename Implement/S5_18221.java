package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_18221 {

    static int N;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        
        int px = 0, py = 0; // 교수 좌표
        int sx = 0, sy = 0; // 성규 좌표
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 5) {
                    px = i;
                    py = j;
                } else if (board[i][j] == 2) {
                    sx = i;
                    sy = j;
                }
            }
        }

        int std = (int) Math.sqrt(Math.pow(px - sx, 2) + Math.pow(py - sy, 2));
        if (std < 5) {
            System.out.print(0);
            return;
        }

        // 학생 수 체크
        int cnt = 0;
        int fx = px < sx ? px : sx;        
        int tx = px < sx ? sx : px;
        int fy = py < sy ? py : sy; 
        int ty = py < sy ? sy : py;
        for (int i = fx; i <= tx; i++) {
            for (int j = fy; j <= ty; j++) {
                if (board[i][j] == 1) cnt++;
            }
        }

        System.out.print(cnt >= 3 ? 1 : 0);
    }
}
