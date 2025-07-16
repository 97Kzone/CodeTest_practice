package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S4_20937 {

    static int N;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[50001];

        st = new StringTokenizer(br.readLine());
        int v;
        for (int i = 0; i < N; i++) {
            v = Integer.parseInt(st.nextToken());
            nums[v]++;
        }
        
        int res = 0;
        for (int i = 0; i < 50001; i++) {
            res = Math.max(res, nums[i]);
        }

        System.out.println(res);
    }
}
