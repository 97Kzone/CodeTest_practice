package contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3_23971 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[4];
        int idx = 0;

        while (st.hasMoreTokens()) {
            arr[idx++] = Integer.parseInt(st.nextToken());
        }

        double H = arr[0];
        double W = arr[1];
        double N = arr[2];
        double M = arr[3];

        int a = (int) Math.ceil(H / (N + 1));
        int b = (int) Math.ceil(W / (M + 1));

        System.out.print(a * b);
    }
}
