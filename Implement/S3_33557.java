package Implement;

import java.io.*;

public class S3_33557 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().trim().split(" ");
            String A = input[0];
            String B = input[1];
            
            long C = Long.parseLong(A) * Long.parseLong(B);
            
            int A_length = A.length();
            int B_length = B.length();
            
            if (A_length < B_length) {
                String temp = A;
                A = B;
                B = padLeft(temp, B_length, '1');
            } else if (B_length < A_length) {
                B = padLeft(B, A_length, '1');
            }
            
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < A.length(); j++) {
                int digitA = Character.getNumericValue(A.charAt(j));
                int digitB = Character.getNumericValue(B.charAt(j));
                sb.append(digitA * digitB);
            }
            
            long D = Long.parseLong(sb.toString());
            
            if (C == D) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
    
    static String padLeft(String str, int length, char padChar) {
        if (str.length() >= length) {
            return str;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length - str.length(); i++) {
            sb.append(padChar);
        }
        sb.append(str);
        return sb.toString();
    }
}