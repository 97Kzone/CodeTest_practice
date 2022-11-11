import java.util.*;

public class D3_1206J {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int t=1; t<11; t++) {
            int N = sc.nextInt();
            int[] nums = new int[N];
            
            for (int i=0; i<N; i++) {
                nums[i] = sc.nextInt();
            }
            
            int res = 0;
            for (int i=2; i<N-2; i++) {
                int tmp = Math.max(Math.max(nums[i-2], nums[i-1]), Math.max(nums[i+1], nums[i+2]));
                if (tmp > nums[i]) continue;

                res += nums[i]-tmp;
            }

            System.out.printf("#%d %d\n", t, res);
        }
    }    
}
