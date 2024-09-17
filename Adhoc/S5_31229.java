package Adhoc;

import java.io.*;

public class S5_31229 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        int v = 1;
        for (int i = 0; i < N; i++) {
            sb.append(v + " ");
            v += 2;
        }

        System.out.print(sb);
    }
}
