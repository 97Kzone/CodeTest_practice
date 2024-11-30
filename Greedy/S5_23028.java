package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_23028 {

    static int N, A, B;
    static int mA = 66;
    static int mB = 130;
    static int mN = 8;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        if (A >= mA && B >= mB) {
            System.out.print("Nice");
            return;
        }

        int a, b, tmp;
        for (int i = 0; i < 10; i++) {
            N++;
            if (N > mN)
                break;

            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            A += (a * 3);
            tmp = 6 - a;
            B += (a * 3);

            B += tmp <= b ? (tmp * 3) : (b * 3);
        }
        
        System.out.print(A >= mA && B >= mB ? "Nice" : "Nae ga wae");
    }
}
