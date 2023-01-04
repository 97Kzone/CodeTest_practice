import java.util.*;

public class D4_3234 {
    static int N, res;
    static int[] nums, arr;
    static boolean[] check;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t=1; t<=T; t++) {
            N = sc.nextInt();
            nums = new int[N];
            arr = new int[N];
            check = new boolean[N];
            res = 0;
            for (int i=0; i<N; i++) {
                nums[i] = sc.nextInt();
            }
            
            pm(0);
            System.out.printf("#%d %d\n", t, res);
        }
    }

    //순열
    public static void pm(int v) {
        if (v == N) count(0, 0, 0);
        for (int i=0; i<N; i++) {
            if (!check[i]) {
                arr[v] = nums[i];
                check[i] = true;
                pm(v+1);
                check[i] = false;
            }
        }
    }

    //가능한 경우인지 확인
    public static void count(int l, int r, int v) {
        if (l < r) return;

        if (v == N) {
            res += 1; 
            return;
        }
        count(l+arr[v], r, v+1);
        count(l, r+arr[v], v+1);
    }
    
}
