import java.util.*;

public class D2_1970 {
    static int[] nums = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t=1; t<=T; t++) {
            int N = sc.nextInt();
            String res = "";
            
            for (int i=0; i<8; i++) {
                int v = N / nums[i];
                N = N%nums[i];

                res += v + " ";
            }

            System.out.printf("#%d\n", t);
            System.out.println(res);
        }
    }    
}
