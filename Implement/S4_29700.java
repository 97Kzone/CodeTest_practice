package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class S4_29700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int res = 0;
        String[] nums;
        for (int i = 0; i < N; i++) {
            nums = br.readLine().split("1");
            
            for (String s : nums) {
                if (s.length() >= K) {
                    res += (s.length() - K + 1);
                }
            }
        }
        
        System.out.print(res);
    }
}
