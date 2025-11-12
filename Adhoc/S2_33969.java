package Adhoc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S2_33969 {
    static int N, M;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        int blacks = 0;
        
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                if (s.charAt(j) == 'x') {
                    blacks++;
                }
            }
        }
        
        for (int i = 0; i <= blacks / 9; i++) {
            if ((blacks - 9 * i) % 11 == 0) {
                bw.write((blacks - 9 * i) / 11 + " " + i + "\n");
                bw.flush();
                bw.close();
                return;
            }
        }
        
        bw.flush();
        bw.close();
    }
}
