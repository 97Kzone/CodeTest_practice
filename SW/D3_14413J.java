import java.util.*;

public class D3_14413J {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();

        for (int t=1; t<=T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] check = {0, 0, 0, 0};

            for (int i=0; i<N; i++) {
                String s = sc.next();
                for (int j=0; j<M; j++) {
                    if (s.charAt(j) == '#') {
                        if ((i+j) % 2 == 0) {
                            check[0] += 1;
                        } else {
                            check[1] += 1;
                        }
                    } 
                    else if (s.charAt(j) == '.') {
                        if ((i+j) % 2 == 0) {
                            check[2] += 1;
                        } else {
                            check[3] += 1;
                        }
                    }
                }
            }
            String res = "possible";
            if ((check[0] > 0 && check[1] > 0) || (check[0] > 0 && check[2] > 0) || (check[2] > 0 && check[3] > 0) || 
            (check[1] > 0 && check[3] > 0)) {
                res = "impossible";
            }

            System.out.printf("#%d %s\n", t, res);
        }
    }    
}
