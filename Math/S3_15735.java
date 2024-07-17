package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_15735 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Integer.parseInt(br.readLine());

        long res = (long)Math.floor((N * (N + 2) * ((2 * N) + 1)) / 8);
        System.out.print(res);
    }
}
