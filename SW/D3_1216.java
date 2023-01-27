import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_1216 {
    static char[][] board;
    static int res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb;

        String T;
        for (int t = 1; t <= 10; t++) {
            T = br.readLine(); //버리는 값
            board = new char[100][100]; // 100x100 고정
    
            for (int i = 0; i < 100; i++) {
                board[i] = br.readLine().toCharArray();
            }

            res = 0;

            loop:
            for (int k = 100; k > 0; k--) {
                for (int i = 0; i < 100; i++) {
                    for (int j = 0; j <= 100-k; j++) {
                        if (check1(i, j, k) || check2(j, i, k)) {
                            res = k;
                            break loop;              
                        }
                    }
                }
            }
            System.out.printf("#%d %d\n", t, res);
        }
    }

    //행 
    static boolean check1(int i, int j, int n) {
        for (int k = 0; k < n/2; k++) {
            if(board[i][j + k] != board[i][j+n-1-k]) {
                return false;
            }
        }
        return true;
    }

    //열
    static boolean check2(int i, int j, int n) {
        for (int k = 0; k < n/2; k++) {
            if (board[i+k][j] != board[i+n-1-k][j]) {
                return false;
            }
        }
        return true;
    }
}
