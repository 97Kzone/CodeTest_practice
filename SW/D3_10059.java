import java.util.*;

public class D3_10059 {
    static int a, b, c;
    static String[] nums = {"NA", "MMYY", "YYMM", "AMBIGUOUS"};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        
        for (int t=1; t<=T; t++) {
            int s = Integer.parseInt(sc.nextLine());
            a = s/100;
            b = s%100;
            
            c = 0;
            if (a > 0 && a < 13) {
                c += 1;
            }

            if (b > 0 && b < 13) {
                c += 2;
            }
            
            System.out.printf("#%d %s\n", t, nums[c]);
        } 
    }    
}
