package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_2980 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int res = 0;
        int time = 0;

        int D, R, G, diff;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            D = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            G = Integer.parseInt(st.nextToken());

            time += D - res;
            res = D;

            diff = time % (R + G);
            if (diff < R)
                time += R - diff;
        }
        
        time += L - res;
        System.out.print(time);
    }
}
