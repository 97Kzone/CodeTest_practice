package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_9342 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        String s;
        String std = "^[A-F]?A+F+C+[A-F]?$";
        for (int t = 0; t < T; t++) {
            s = br.readLine();

            
            if (s.matches(std)) sb.append("Infected!");
            else sb.append("Good");
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}
