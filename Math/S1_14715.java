package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_14715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 1;

        boolean flag = true;
        while (flag) {
            flag = false;

            for (int i = 2; i * i <= N; i++) {
                if (N % i == 0) {
                    flag = true;
                    N /= i;
                    cnt++;
                    break;
                }
            }
        }

        int res = (int) Math.ceil(Math.log10(cnt) / Math.log10(2));
        System.out.print(res);
    }
}
