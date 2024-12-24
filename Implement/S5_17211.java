package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_17211 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        double M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        double[] nums = new double[4];
        for (int i = 0; i < 4; i++) {
            nums[i] = Double.parseDouble(st.nextToken());
        }
        M = (1 - M) * 1000;

        for (int i = 0; i < N; i++) {
            M = M * nums[0] + (1000 - M) * nums[2];
        }

        System.out.println(String.format("%.0f", M));
        System.out.print(String.format("%.0f", 1000 - M));
    }
}
