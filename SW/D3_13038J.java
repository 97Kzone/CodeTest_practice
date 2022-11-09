import java.util.*;

public class D3_13038J {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for (int t=1; t<=T; t++) {
            int N = sc.nextInt();
            sc.nextLine();

            String[] days = sc.nextLine().split(" ");
            int res = 1000000;

            for (int i=0; i<7; i++) {
                if (days[i].equals("1")){
                    int s = i, cnt = 0;

                    while (true) {
                        if (days[s%7].equals("1")) {
                            cnt += 1;
                        }
                        s += 1;
                        if (cnt == N) {

                            res = Math.min(res, s-i);
                            break;
                        }
                    }
                }
            }
            System.out.printf("#%d %d\n", t, res);
        }
    }    
}
