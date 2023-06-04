package Bclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_10726 {
    static int N, M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            N = (1 << N) - 1;

            int diff = N | M;
            String res;
            if (diff == M)
                res = "ON";
            else
                res = "OFF";

            sb.append("#" + t + " ").append(res + "\n");
        }
        System.out.println(sb.toString());
    }
}
