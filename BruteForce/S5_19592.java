package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_19592 {
    
    static int N, X, Y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        int[] V;
        double std;
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            
            V = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                V[i] = Integer.parseInt(st.nextToken());
            }

            std = Double.MAX_VALUE;
            for (int i = 0; i < N-1; i++) {
                std = Math.min(std, (double) X / V[i]);
            }

            int l, r, m;
            if (std > (double) X / V[N-1]) sb.append(0 + "\n");
            else {
                l = 0;
                r = Y;

                while(l <= r) {
                    m = (l + r) / 2;

                    if (std > (((double) X - m) / V[N-1]) + 1) {
                        r = m - 1;
                    } else {
                        l = m + 1;
                    }
                }

                sb.append(l > Y ? -1 : l).append("\n");
            }
        }
        System.out.print(sb.toString());
    }
}
