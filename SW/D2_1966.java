import java.util.*;

public class D2_1966 {
    static int N;
    static int[] nums;
    static String res;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        for (int t=1; t<=T; t++) {
            N = sc.nextInt();
            nums = new int[N];

            for (int i=0; i<N; i++) {
                nums[i] = sc.nextInt();
            }

            Arrays.sort(nums);
            res = "";
            for (int n : nums) {
                res += n + " ";
            }

            System.out.printf("#%d %s\n", t, res);
        }
    }
}
