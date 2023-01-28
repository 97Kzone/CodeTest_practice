import java.util.*;

public class D4_3234 {
    static int N, res;
    static int[] nums, board;
    static boolean[] check;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();

            nums = new int[N];
            board = new int[N];
            check = new boolean[N];

            for (int i = 0; i < N; i++) {
                nums[i] = sc.nextInt();
            }

            pm(0);
            System.out.printf("#%d %d\n", t, res);
        }
    }

    static void pm(int n) {
        if (n == N) count(0, 0, 0);
        
        for (int i = 0; i < N; i++) {
            if (!check[i]) { // 사용하지 않은 추일 때,
                board[n] = nums[i];
                check[i] = true;
                pm(n+1);
                check[i] = false;
            }
        }
    }

    static void count(int l, int r, int v) {
        if (r > l) return; 

        if (v == N) {
            res++;
            return;
        }

        count(l + board[v], r, v+1);
        count(l, r + board[v], v+1);
    }
}
