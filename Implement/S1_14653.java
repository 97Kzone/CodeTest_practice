package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S1_14653 {

    static int N, K, Q;
    static int[] count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        count = new int[26];
        int std = 0;

        int r, idx;
        char p;
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            
            r = Integer.parseInt(st.nextToken());
            p = st.nextToken().charAt(0);

            idx = p - 'A';
            count[idx] = r;
            std = idx;
        }

        for (int i = Q; i< K; i++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            p = st.nextToken().charAt(0);

            count[p - 'A'] = count[std];
        }

        boolean flag = false;
        for (int i = 1; i < N; i++) {
            if (count[i] != count[std]) {
                bw.write((char) (i + 'A') + " ");
                flag = true;
            }
        }

        if (!flag) bw.write("-1");
        
        bw.flush();
        bw.close();
    }
}
