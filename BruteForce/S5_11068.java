package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_11068 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int num;
        boolean flag;
        for (int t = 0; t < T; t++) {
            num = Integer.parseInt(br.readLine());

            flag = false;
            for (int i = 2; i <= 64; i++) {
                if (checkNum(changeNum(num, i))) {
                    sb.append("1" + "\n");
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                sb.append("0" + "\n");
            }
        }
        System.out.print(sb.toString());
    }
    
    static String changeNum(int num, int v) {
        StringBuilder res = new StringBuilder();
        int tmp;
        
        while (num > 0) {
            tmp = num % v;
            
            if (tmp < 10) res.append(tmp);
            else res.append((char)('A' + tmp - 10));    

            num /= v;
        }
        
        return res.toString();
    }

    static boolean checkNum(String num) {
        return new StringBuilder(num).toString().equals(new StringBuilder(num).reverse().toString());
    }

    static boolean checkNum(int num) {
        return checkNum(String.valueOf(num));
    }
}
