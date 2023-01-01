import java.util.*;

public class D2_1974 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        for(int t=1; t<=T; t++) {
            int[][] board = new int[9][9];
            int res = 0;
            boolean flag = true; 

            for(int i=0; i<9; i++) {
                for(int j=0; j<9; j++) {
                    board[i][j] = sc.nextInt();
                }
            }

            //가로검사
            int tmp;
            for (int i=0; i<9; i++) {
                tmp = 0;
                for (int j=0; j<9; j++) {
                    tmp += board[i][j];
                }
                if (tmp != 45) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                System.out.printf("#%d %d\n", t, res);
                continue;
            }

            //세로검사
            for (int i=0; i<9; i++) {
                tmp = 0;
                for (int j=0; j<9; j++) {
                    tmp += board[j][i];
                }
                if (tmp != 45) {
                    flag = false;
                    break;
                }
            }

            if (!flag) {
                System.out.printf("#%d %d\n", t, res);
                continue;
            }

            //구간검사
            for (int i=0; i<9; i+=3) {
                for (int j=0; j<9; j+=3){
                    flag = check(board, i, j);
                }
                if (!flag) {
                    flag = false;
                    break;
                }
            }

            if (!flag) {
                System.out.printf("#%d %d\n", t, res);
                continue;
            }
            System.out.printf("#%d %d\n", t, res+1);
        }
    }
    public static boolean check(int[][] board, int i, int j) {
        int tmp = 0;
        for (int a=0; a<3; a++){
            for (int b=0; b<3; b++){
                tmp += board[i+a][j+b];
            }
        }
        if (tmp != 45) return false;
        return true;
    }
}
