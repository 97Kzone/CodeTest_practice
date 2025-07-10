package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class S5_4378 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String std = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";
        String s;
        //StringBuilder sb;

        int idx;
        while((s = br.readLine()) != null) {
            //sb = new StringBuilder();

            for (char c : s.toCharArray()) {
                if (c == ' ') {
                    bw.write(' ');
                    continue;
                }

                idx = std.indexOf(c);
                if (idx > 0) {
                    bw.append(std.charAt(idx - 1));
                } else {
                    bw.append(c);
                }
            }
            bw.append("\n");
        }
        
        bw.flush();
        bw.close();

    }
}
