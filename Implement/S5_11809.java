package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class S5_11809 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        char[] num1 = br.readLine().toCharArray();
        char[] num2 = br.readLine().toCharArray();
        int l1 = num1.length;
        int l2 = num2.length;

        int std = Math.min(l1, l2);

        for (int i = 0; i < std; i++) {
            if (num1[l1 - 1 - i] < num2[l2 - 1 - i]) {
                num1[l1 - 1 - i] = ' ';
            } else if (num1[l1 - 1 - i] > num2[l2 - 1 - i]) {
                num2[l2 - 1 - i] = ' ';
            }
        }

        String tmp1 = String.valueOf(num1).replace(" ", "");
        String tmp2 = String.valueOf(num2).replace(" ", "");

        bw.write("".equals(tmp1) ? "YODA" : Integer.parseInt(tmp1) + "");
        bw.write("\n");

        bw.write("".equals(tmp2) ? "YODA" : Integer.parseInt(tmp2) + "");

        bw.flush();
        bw.close();
    }
}

