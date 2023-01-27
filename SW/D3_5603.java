import java.util.Scanner;

public class D3_5603 {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            
            int[] nums = new int[N];
            int std = 0;
            for (int i = 0; i < N; i++) {
                nums[i] = sc.nextInt();
                std += nums[i];
            }

            std /= N;
            int res = 0;
            for (int i = 0; i < N; i++) {
                res += nums[i]-std > 0 ? nums[i]-std : 0;
            }

            System.out.printf("#%d %d\n", t, res);
        }
    }
}
