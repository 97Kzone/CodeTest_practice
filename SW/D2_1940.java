import java.util.*;

public class D2_1940 {
    static int N, res, s;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t=1; t<=T; t++) {
            N = sc.nextInt();
            sc.nextLine();

            res = 0;
            s = 0;
            for (int i=0; i<N; i++) {
                String[] comm = sc.nextLine().split(" ");
                if (comm[0].equals("0")) {
                    res += s;
                } else if (comm[0].equals("1")) {
                    s += Integer.parseInt(comm[1]);
                    res += s;
                } else {
                    if (s > Integer.parseInt(comm[1])) {
                        s -= Integer.parseInt(comm[1]);
                        res += s;
                    } else {
                        s = 0;
                    }
                }
            }
            System.out.printf("#%d %d\n", t, res);
        }
    }    
}
