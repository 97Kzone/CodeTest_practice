import java.util.*;

public class D3_2063 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];

        for(int i=0; i<N; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);
        System.out.println(nums[N/2]);
    }
}
