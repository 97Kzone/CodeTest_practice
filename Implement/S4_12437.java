package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S4_12437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int a, b, c;
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            int res = 0;
            int tmp = 0;
            for (int i = 0 ; i < a; i++) {
                res += (b + tmp) / c;

                if ((b + tmp) % c == 0) tmp = 0;
                else {
                    res++;
                    tmp = (b + tmp) % c;
                }
            }

            bw.write("Case #" + t + ": " + res);
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
