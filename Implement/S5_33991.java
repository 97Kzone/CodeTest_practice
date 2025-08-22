package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S5_33991 {

    static int x1, x2, x3, y1, y2, y3;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());
        x3 = Integer.parseInt(st.nextToken());
        y3 = Integer.parseInt(st.nextToken());

        int Q = Integer.parseInt(br.readLine());

        int x, y, t1, t2, t3;
        int d1, d2, d3; // 역 별 거리
        int v1, v2, v3;
        while(Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            t1 = Integer.parseInt(st.nextToken());
            t2 = Integer.parseInt(st.nextToken());
            t3 = Integer.parseInt(st.nextToken());

            d1 = Math.abs(x1 - x) + Math.abs(y1 - y);
            d2 = Math.abs(x2 - x) + Math.abs(y2 - y);
            d3 = Math.abs(x3 - x) + Math.abs(y3 - y);

            v1 = ((d1 + t1 - 1) / t1) * t1;
            v2 = ((d2 + t2 - 1) / t2) * t2;
            v3 = ((d3 + t3 - 1) / t3) * t3;

            bw.write(Math.min(v1, Math.min(v2, v3)) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
