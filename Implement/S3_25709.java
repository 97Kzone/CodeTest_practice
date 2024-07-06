package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_25709 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int num;
        int res = 0;
        while (true) {
            if ("".equals(s) || "0".equals(s)) {
                break;
            }

            int tmp = s.indexOf("1");
            if (tmp == -1) {
                num = Integer.parseInt(s) - 1;
                s = String.valueOf(num);
                res++;
            } else {
                s = s.substring(0, tmp) + s.substring(tmp + 1, s.length());
                res++;
                if ("".equals(s)) {
                    break;
                }
                num = Integer.parseInt(s);
                s = String.valueOf(num);
            }
        }

        System.out.print(res);
    }
}
