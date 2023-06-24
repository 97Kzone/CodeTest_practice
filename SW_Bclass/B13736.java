package SW_Bclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B13736 {
    static int X, Y, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            long res = check(X, Y, K);
            sb.append("#" + t + " ").append(res + "\n");
        }

        System.out.print(sb.toString());
    }
    
    static long check(int a, int b, int c) {
        int sum = a + b;
        
        long num1 = 1;
        long num2 = 2;
        while (c > 0) {
            if (c % 2 == 1) {
                num1 = (num1 * num2) % sum;
            }
            num2 = (num2 * num2) % sum;
            c /= 2;
        }

        long res = (num1 * a) % sum;
        return res > sum / 2 ? sum - res : res;
    } 

}
