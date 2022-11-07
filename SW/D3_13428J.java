import java.util.*;

public class D3_13428J {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for (int t=1; t<=T; t++) {
            String s = sc.next();
            int M = Integer.parseInt(s);
            int m = Integer.parseInt(s);
            
            for (int i=0; i<s.length(); i++) {
                for (int j=i+1; j<s.length(); j++) {
                    char[] nums = s.toCharArray();
                    
                    char tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;

                    if (nums[0] == '0') continue;
                    
                    int num = Integer.parseInt(new String(nums));
                    M = Math.max(M, num);
                    m = Math.min(m, num);
                }
            }

            System.out.printf("#%d %d %d\n", t, m, M);
        }
    }    
}
