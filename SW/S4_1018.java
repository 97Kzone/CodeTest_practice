import java.util.*;

public class S4_1018 {
    static int N, M, res;
    static int idx1, idx2;
    static String[] board;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        
        board = new String[N];
        for (int i=0; i<N; i++) {
            board[i] = sc.nextLine();
        }
        res = 1000000;
        for (int a=0; a<N-7; a++) {
            for (int b=0; b<M-7; b++) {
                idx1 = 0;
                idx2 = 0;

                for (int i=a; i<a+8; i++) {
                    for (int j=b; j<b+8; j++) {
                        char c = board[i].charAt(j);
                        if ((i+j)%2 == 0) {
                            if (c != 'W') idx1 += 1;
                            if (c != 'B') idx2 += 1;
                        } else {
                            if (c != 'B') idx1 += 1;
                            if (c != 'W') idx2 += 1;
                        }
                    }
                }
                res = Math.min(res, Math.min(idx1, idx2)); 
            } 
        }
        System.out.println(res);
    }
}