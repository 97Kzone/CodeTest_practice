package PrefixSum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class S4_5874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] ch = br.readLine().toCharArray();
        int cnt = 0;
        int sum = 0;

        for (int i = 1; i < ch.length; i++) {
            if (ch[i] == ch[i-1]) {
                if (ch[i] == '(') cnt++;
                else sum += cnt;
            }
        }

        bw.write(sum + "");
        bw.flush();
        bw.close();
    }
}

