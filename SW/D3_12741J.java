import java.util.*;

public class D3_12741J {
    public static void main(String[] args){ 
        Scanner sc = new Scanner(System.in);
    
        int T = sc.nextInt();
        sc.nextLine();
        for (int t=1; t<=T; t++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            
            int res = Math.min(b, d) - Math.max(a, c);
            if (res < 0) res = 0;
            System.out.printf("#%d %d\n", t, res);
        }
    }
}
