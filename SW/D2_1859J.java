import java.util.Scanner;

public class D2_1859J {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t=1; t <= T; t++) {
            int N = sc.nextInt();
            int[] nums = new int[N];

            for (int i=0; i<N; i++) {
                nums[i] = sc.nextInt();
            }

            long res = 0;
            int v = nums[N-1];
            for (int i=N-1; i>=0; i--) {
                if (v > nums[i]) {
                    res += v - nums[i];
                } else {
                    v = nums[i];
                }
            }
            System.out.printf("#%d %d\n", t, res);
        }
        sc.close();
    }
}
