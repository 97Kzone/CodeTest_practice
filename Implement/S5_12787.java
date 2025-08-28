package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class S5_12787 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int cmd;
        BigInteger num;
        String bNum;
        
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            cmd = Integer.parseInt(st.nextToken());

            if (cmd == 1) {
                String ipv8 = st.nextToken();
                String[] octets = ipv8.split("\\.");
                
                bNum = "";
                for (String octet : octets) {
                    int octetValue = Integer.parseInt(octet);
                    String octetBinary = Integer.toBinaryString(octetValue);
                    bNum += String.format("%8s", octetBinary).replace(' ', '0');
                }

                num = new BigInteger(bNum, 2);
                bw.write(num.toString() + "\n");
                
            } else {
                num = new BigInteger(st.nextToken());
                
                bNum = num.toString(2);
                while (bNum.length() < 64) {
                    bNum = "0" + bNum;
                }
                
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < 8; i++) {
                    String octetBinary = bNum.substring(i * 8, (i + 1) * 8);
                    int octetValue = Integer.parseInt(octetBinary, 2);
                    result.append(octetValue);
                    
                    if (i < 7) {
                        result.append(".");
                    }
                }
                
                bw.write(result.toString() + "\n");
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}