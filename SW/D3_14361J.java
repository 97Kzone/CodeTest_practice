import java.util.*;

public class D3_14361J {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();

        for (int t=1; t<=T; t++){
            int num = sc.nextInt();
            String std = String.valueOf(num);
            
            boolean flag = true;
            for (int i=2; i<10; i++) {
                String s = String.valueOf(num*i);
                flag = true;
                if (std.length() != s.length()) {
                    flag = false;
                    break;
                }

                for (int j=0; j<s.length(); j++) {
                    if (!std.contains(String.valueOf(s.charAt(j)))) {
                        flag = false;
                        break;
                    }
                }
 
                if (flag) {
                    break;
                }
            }
            System.out.printf("#%d %s\n", t, flag ? "possible" : "impossible");
        }
    }    
}
