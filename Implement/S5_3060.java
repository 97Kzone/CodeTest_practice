package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S5_3060 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int N;
        int std, day;
        while(T-- > 0) {
            N = Integer.parseInt(br.readLine());
            std = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 6; i++) {
                std += Integer.parseInt(st.nextToken());
            }


            day = 1;
            while(true) {
                if (N / std == 0) break;
                std *= 4;
                day++;
            }

            bw.write(day + "\n");
        }

        bw.flush();
        bw.close();
    }

    
    
}
