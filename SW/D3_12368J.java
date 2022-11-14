import java.util.*;

public class D3_12368J {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();

        for (int t=1; t<=T; t++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            System.out.printf("#%d %d\n", t, (A+B)%24);
        }
        sc.close();
    }    
}
