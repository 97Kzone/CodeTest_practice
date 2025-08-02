package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S5_11999 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int std;
        int res = 0;

        for (int i = 0; i <= 1000; i++) {
            for (int j = 0; j <= 1000; j++) {
                std = (X * i) + (Y * j); 
                if (std<= M) {
                    res = Math.max(res, std);
                }
            }
        }

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
    }
}
