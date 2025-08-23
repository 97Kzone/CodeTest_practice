package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class S5_27833 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        String[] words;
        String s1, s2, s3;

        int tmp;
        for (int i = 0; i < T * 2; i++) {
            if (i % 2 == 0) {
                br.readLine();
                continue;
            }

            words = br.readLine().split("[+=]");

            s1 = words[0].trim();
            s2 = words[1].trim();
            s3 = words[2].trim();
 
            tmp = 0;
            if (s1.contains("machula")) {
                tmp = Integer.parseInt(s3) - Integer.parseInt(s2);
                bw.write(tmp + " + " + s2 + " = " + s3);
            } else if (s2.contains("machula")) {
                tmp = Integer.parseInt(s3) - Integer.parseInt(s1);
                bw.write(s1 + " + " + tmp + " = " + s3);
            }else if (s3.contains("machula")) {
                tmp = Integer.parseInt(s1) + Integer.parseInt(s2);
                bw.write(s1 + " + " + s2 + " = " + tmp);
            }
            
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
