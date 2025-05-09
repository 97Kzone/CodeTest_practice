package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class S4_2890 {

    static int R, C;
    static char[][] board;

    static class Team {
        int num;
        int cnt;

        Team(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        List<Team> list = new ArrayList<>();

        int idx1, idx2, cnt;
        for (int i = 0; i < R; i++) {
            idx1 = -1;
            idx2 = -1;
            cnt = -1;

            for (int j = 0; j < C; j++) {
                if (board[i][j] >= '1' && board[i][j] <= '9') {
                    idx1 = j;
                    cnt = board[i][j] - '0';
                }

                if (board[i][j] == 'F') {
                    idx2 = j;
                }
            }

            if (cnt != -1 && idx1 != -1 && idx2 != -1) {
                list.add(new Team(cnt, idx2 - idx1));
            }
        }

        list.sort(Comparator.comparingInt(o -> o.cnt));

        int[] rank = new int[10]; 

        int currentRank = 1;
        for (int i = 0; i < list.size(); i++) {
            if (i > 0 && list.get(i).cnt > list.get(i - 1).cnt) {
                currentRank++; 
            }
            rank[list.get(i).num] = currentRank;
        }

        for (int i = 1; i <= 9; i++) {
            if (rank[i] != 0) {
                sb.append(rank[i] + "\n");
            }
        }

        System.out.print(sb.toString());
    }
}
