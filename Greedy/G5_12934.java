package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_12934 {

    static long X, Y, std;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());
        std = X + Y;

        long n = 1;
        long tmp;
        while (true) {
            tmp = (n * (n + 1)) / 2;
            if (std < tmp) {
                System.out.print(-1);
                return;
            }

            if (std == tmp) break;
            n++;
        }
        
        long res = 0;
        while (X > 0) {
            X -= n;
            n--;
            res++;
        }

        System.out.print(res);
    }
}
