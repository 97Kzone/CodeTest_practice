package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class S1_24742 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int M = Integer.parseInt(br.readLine());

        long a = 0;
        long b = 1;
        long tmp;
        for (int i = 0; i < M; i++) {
            tmp = (a + b) % 1_000_007;
            a = b;
            b = tmp;
        }
        
        bw.write(a + "");
        bw.flush();
        bw.close();
    }
    
}
