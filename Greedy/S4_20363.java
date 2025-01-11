package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_20363 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int res = 0;
        if (X > Y) {
            res += X;
            res += Y;
            res += Y / 10;
        } else {
            res += Y;
            res += X;
            res += X / 10;
        }

        System.out.print(res);
    }
}
