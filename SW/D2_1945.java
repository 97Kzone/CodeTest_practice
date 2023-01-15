import java.util.*;

public class D2_1945 {
    static int N;
    static int[] nums = {2, 3, 5, 7, 11};
    static int[] res;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t=1; t<=T; t++) {
            N = sc.nextInt();
            res = new int[5];
        
            check(N);
            String s = "";
            for (int v : res) {
                s += Integer.toString(v) + " ";
            }
            System.out.printf("#%d %s\n", t, s);
        }
    }

    static void check(int n) {
        int idx = 0;
        int std = nums[idx];

        while (std <= n) {
            if (n % std == 0) {
                res[idx] += 1;
                n /= std;
            } else {
                idx += 1;
                std = nums[idx];
            }
        }
    }
}