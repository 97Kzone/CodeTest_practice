import java.util.*;

public class D3_14555J {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();

        for (int t=1; t<=T; t++) {
            char[] str = sc.nextLine().toCharArray();
            int res = 0;
            for (int i=1; i<str.length; i++) {
                if (str[i] == ')') {
                    if (str[i-1] == '(' || str[i-1] == '|') {
                        res += 1;
                    }
                } 
                else if (str[i] == '|') {
                    if (str[i-1] == '(') {
                        res += 1;
                    }
                }
            }

            System.out.printf("#%d %d\n", t, res);
        }
    }    
}
