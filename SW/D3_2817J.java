import java.util.*;

public class D3_2817J {
    static int[] nums;
    static int N, K, res;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        sc.nextLine();

        for (int t=1; t<=T; t++) {
            N = sc.nextInt();
            K = sc.nextInt();
            nums = new int[N];
            res = 0;
            for (int i=0; i<N; i++) {
                nums[i] = sc.nextInt();
            }

            DFS(0, 0);
            System.out.printf("#%d %d\n", t, res);
        }
        sc.close();
    }

    public static void DFS(int idx, int sum) {
        if (idx == N) return;
        int temp = sum + nums[idx];
        
        if (temp == K) res++;

        DFS(idx+1, sum);
        DFS(idx+1, temp);
    }
}
