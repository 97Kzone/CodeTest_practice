package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class S5_9492 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N;
        String[] words;

        int mid;
        int l, r;
        while(true) {
            N = Integer.parseInt(br.readLine());

            if (N == 0) break;
            
            words = new String[N];
            for (int i = 0; i < N; i++) {
                words[i] = br.readLine();
            }

            mid = (N % 2 == 0) ? N / 2 : (N / 2) + 1;
            l = 0;
            r = mid;
            while(l < mid || r < N) {
                if (l < mid) {
                    bw.write(words[l++] + "\n");
                }

                if (r < N) {
                    bw.write(words[r++] + "\n");
                }
            }
        }        

        bw.flush();
        bw.close();
    }
}
