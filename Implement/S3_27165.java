package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S3_27165 {

    static int N, x;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N + 1];

        
        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        int std = 0;
        for (int i = 0; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            if (nums[i] == 1) {
                cnt++;
                if (cnt == 1) std = i;
            }
        }
        x = Integer.parseInt(br.readLine());
        
        boolean flag;
        if (cnt > 2) {
            bw.write("NO");
        } else if (cnt == 0) {
            flag = false;

            for (int i = 0; i <= N - x; i++) {
                if (nums[i] > 2 && nums[i + x] >= 1) {
                    bw.write("YES\n");
                    bw.write(i + " " + (i + x));
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                bw.write("NO");
            }
        } else if (cnt == 1) {
            if (std - x >= 0 && nums[std- x] > 2) {
                bw.write("YES\n");
                bw.write((std - x) + " " + std);
            } else if (std + x <= N && nums[std + x] > 2) {
                bw.write("YES\n");
                bw.write(std + " " + (std + x));
            } else {
                bw.write("NO");
            }
        } else {
            if (std + x <= N && nums[std + x] == 1) {
                bw.write("YES\n");
                bw.write(std + " " + (std + x));
            } else {
                bw.write("NO");
            }
        }

        bw.flush();
        bw.close();
    }
}
