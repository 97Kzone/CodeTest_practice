package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S5_6709 {
    
    static int N, W;
    static long[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        
        long tmp;
        for (int i = 0; i < N; i++) {
            W = Integer.parseInt(br.readLine());

            nums = new long[W];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                nums[j] = Long.parseLong(st.nextToken());
            }

            tmp = nums[0];
            for (int k = 1; k < W; k++) {
                tmp = tmp * nums[k] / gcd(tmp, nums[k]);
            }

            if (tmp < 1_000_000_000) {
                bw.write(tmp + "\n");
            } else {
                bw.write("More than a billion.\n");
            }
        }

        bw.flush();
        bw.close();
    }

    static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
