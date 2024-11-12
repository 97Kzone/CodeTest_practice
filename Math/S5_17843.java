package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S5_17843 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        double[] nums = new double[3];
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 3; i++) {
                nums[i] = Double.parseDouble(st.nextToken());
            }

            nums[1] += nums[2] / 60.0;
            nums[0] *= 5.0;
            nums[0] += (nums[1] / 60.0) * 5.0;

            Arrays.sort(nums);

            double res = 360.0;
            double tmp;
            for (int i = 1; i < 3; i++) {
                tmp = (nums[i] - nums[i - 1]) * 6.0;
                res = Math.min(res, tmp);
            }

            tmp = (nums[0] + 60.0 - nums[2]) * 6.0;
            res = Math.min(res, tmp);
            sb.append(res + "\n");
        }
        
        System.out.print(sb);
    }
}
