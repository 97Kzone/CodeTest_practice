package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class S4_9214 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String num;
        StringBuilder sb;
        int idx = 1;
        int l, cnt, v;
        while (true) {
            num = br.readLine();

            if ("0".equals(num)) break;

            while(true) {
                l = num.length();  
                if (l % 2 == 1) {
                    bw.write("Test " + idx + ": " + num);
                    bw.write("\n");
                    idx++;
                    break;
                }

                sb = new StringBuilder();
                for (int i = 0; i < l - 1; i += 2) {
                    cnt = num.charAt(i) - '0';
                    sb.append(num.substring(i + 1, i + 2).repeat(cnt));
                }
                
                if (num.equals(sb.toString())) {
                    bw.write("Test " + idx + ": " + num);
                    bw.write("\n");
                    idx++;
                    break;
                }
                num = sb.toString();
            }
        }

        bw.flush();
        bw.close();
        br.close();
        
    } 

}
