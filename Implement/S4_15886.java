package Implement;

import java.io.*;

public class S4_15886 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int res = 0;
        char[] s = br.readLine().toCharArray();
        for (int i = 0; i < N - 1; i++) {
            if (s[i] == 'E' && s[i + 1] == 'W') {
                res++;
            }
        }

        System.out.print(res);
    }
}
