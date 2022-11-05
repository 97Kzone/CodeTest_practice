import java.util.Collections;
import java.util.*;

public class D2_1983 {
    static String[] score = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t=1; t<=T; t++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            
            Double[] nums = new Double[N];
            for (int i=0; i<N; i++) {
                double a = sc.nextInt() * 0.35;
                double b = sc.nextInt() * 0.45;
                double c = sc.nextInt() * 0.2;
                
                nums[i] = a+b+c;
            }
            double std = nums[K-1];
            Arrays.sort(nums, Collections.reverseOrder());
            int idx = 0;
            for (int i=0; i<N; i++) {
                System.out.println(nums[i] + " " + std);
                if (nums[i] == std) {
                    idx = i / (N/10); 
                }
            }
            System.out.printf("#%d %s\n", t, score[idx]);
        }
    }    
}
