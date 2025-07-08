package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S5_31416 {

    static int Q;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        Q = Integer.parseInt(br.readLine());

        int ta, tb, va, vb;
        int v1, v2, res;
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            ta = Integer.parseInt(st.nextToken());
            tb = Integer.parseInt(st.nextToken());
            va = Integer.parseInt(st.nextToken());
            vb = Integer.parseInt(st.nextToken());

            res = Integer.MAX_VALUE;
            for (int j = 0; j <= va; j++) {
                v1 = ta * j + tb * vb;
                v2 = ta * (va - j);

                res = Math.min(res, Math.max(v1, v2));
            }

            bw.write(res + "\n");
        }

        bw.close();
        br.close();
    }
}
