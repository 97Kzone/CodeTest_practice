import java.util.Scanner;

public class D4_5672 {
    static int N, l, r;
    static String words;
    static StringBuilder res;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            words = "";

            sc.nextLine();
            for (int i = 0; i < N; i++) {
                words += sc.nextLine();
            }

            res = new StringBuilder();
            check();
            System.out.printf("#%d %s\n", t, res);
        }
    }

    static void check() {
        l = 0;
        r = N-1;

        while (l <= r) {
            if (l == r) {
                res.append(words.charAt(l));
                return;
            }

            if (words.charAt(l) < words.charAt(r)) {
                res.append(words.charAt(l++));
            
            } else if (words.charAt(l) > words.charAt(r)) {
                res.append(words.charAt(r--));
            
            } else {
                int a = l+1;
                int b = r-1;
                
                while (true) {
                    if (a < b) {
                        if (words.charAt(a) < words.charAt(b)) {
                            res.append(words.charAt(l++));
                            break;
                        } else if (words.charAt(a) > words.charAt(b)) {
                            res.append(words.charAt(r--));
                            break;
                        } else {
                            a++;
                            b--;
                        }
                    } else {
                        res.append(words.charAt(l++));
                        break;
                    }
                }
            }
        }
    }
}
