package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S4_16611 {
    static int N, M;
    static String lastN;
    static String cipher;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        lastN = br.readLine();
        cipher = br.readLine();
        
        String result = check();
        
        bw.write(result);
        bw.flush();
        bw.close();
    }
    
    static String check() {
        char[] plain = new char[M];
        
        for (int i = 0; i < N; i++) {
            plain[M - N + i] = lastN.charAt(i);
        }
        
        for (int i = M - N - 1; i >= 0; i--) {
            int k = toNum(plain[i + N]);
            int b = toNum(cipher.charAt(i + N));
            int a = (b - k + 26) % 26;
            plain[i] = toChar(a);
        }
        
        return new String(plain);
    }
    
    static int toNum(char c) {
        return c - 'a';
    }
    
    static char toChar(int n) {
        return (char)(n + 'a');
    }
}