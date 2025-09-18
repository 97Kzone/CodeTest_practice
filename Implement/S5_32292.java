package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class S5_32292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        int N, std;
        String s;
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            s = br.readLine();
            std = s.length();
            while(true) {
                s = s.replaceFirst("ABB", "BA");
                
                if (std == s.length()) break;
                std = s.length();
            }
            bw.write(s + "\n");
        }

        bw.flush();
        bw.close();
    }
}
