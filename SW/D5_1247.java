import java.util.*;

public class D5_1247 {
    static int N;
    static int[][] nums;
    static int[] std;
    static boolean[] visit;
    static int res;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t=1; t<=T; t++) {
            N = sc.nextInt(); 
            nums = new int[N+2][2]; //회사, 집, 고객 N
            std = new int[N];

            for (int i=0; i<N+2; i++) {
                nums[i][0] = sc.nextInt();
                nums[i][1] = sc.nextInt();
            }
            visit = new boolean[N+2];
            visit[0] = true;
            visit[1] = true;
            res = (int) Math.pow(10, 6);
            pm(nums, visit, std, 2);

            System.out.printf("#%d %d\n", t, res);
        }
    }

    public static void pm(int[][] arr, boolean[] v, int[] check, int n) {
        if(n == N+2) {
            int val = Math.abs(arr[check[0]][0]-arr[0][0]) + Math.abs(arr[check[0]][1]-arr[0][1]);
            for (int i=0; i<N-1; i++) {
                val += Math.abs(arr[check[i]][0]-arr[check[i+1]][0]) + Math.abs(arr[check[i]][1]-arr[check[i+1]][1]);
            }
            val += Math.abs(arr[check[N-1]][0]-arr[1][0]) + Math.abs(arr[check[N-1]][1]-arr[1][1]);

            if (val < res) res = val; return;
        }

        for (int i=2; i<N+2; i++) {
            if(v[i]) continue;
            check[n-2] = i;
            v[i] = true;
            pm(arr, v, check, n+1);
            v[i] = false;
        }
    }
}
