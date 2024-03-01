package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_1515 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num = br.readLine();
        int n = num.length();

        int std = 1, res = 0;
        String tmp;
        boolean flag = true;
        while (flag) {
            tmp = String.valueOf(std);
            for (int i = 0; i < tmp.length(); i++) {
                if (num.charAt(res) == tmp.charAt(i)) res++;

                if (res == n) {
                    flag = false;
                    break;
                }
            }
            std++;
        }
        
        System.out.print(std - 1);
    }
}
