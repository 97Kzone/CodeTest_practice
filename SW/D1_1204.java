import java.util.*;

public class D1_1204 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1; t<=T; t++) {
            int v = sc.nextInt();
            int[] nums = new int[101];
            for (int i=0; i<1000; i++) {
                int n = sc.nextInt();
                nums[n] += 1;
            }
            
            int M = 0;
            int res = 0;
            for (int i=0; i<101; i++) {
                if (nums[i] >= M) {
                    M = nums[i];
                    res = i;
                }
            }

            System.out.printf("#%d %d\n", t, res);
        }
    }    
}
