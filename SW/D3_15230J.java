import java.util.*;

public class D3_15230J {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();
        for (int t=1; t<=T; t++) {
            char[] str = sc.nextLine().toCharArray();
            int res = 0;
            if (str[0]!='a') {
                System.out.printf("#%d %d\n", t, res);
                continue;
            } else {
                res += 1;
                for (int i=1; i < str.length; i++) {
                    if ((int)str[i] - (int)str[i-1] == 1) {
                        res += 1;
                    } else {
                        break;
                    }
                }
            }
            System.out.printf("#%d %d\n", t, res);
        }
    }    
}
