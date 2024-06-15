package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_30803 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int[] onOff = new int[N]; // 0 : ON, 1 : OFF
        
        st = new StringTokenizer(br.readLine());
        long res = 0;
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            res += nums[i];
        }
        
        int Q = Integer.parseInt(br.readLine());
        sb.append(res + "\n");

        int a, b, c;
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            if (a == 1) {
                b = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());

                if (onOff[b - 1] == 0) {
                    res -= nums[b - 1];
                    nums[b - 1] = c;
                    res += nums[b - 1];
                } else {
                    nums[b - 1] = c;
                }
            } else {
                b = Integer.parseInt(st.nextToken());

                if (onOff[b - 1] == 0) {
                    res -= nums[b - 1];
                    onOff[b - 1] = 1;
                } 
                else {
                    res += nums[b - 1];
                    onOff[b - 1] = 0;
                }

            }
            sb.append(res + "\n");
        }
        
        System.out.print(sb);
    }
}
