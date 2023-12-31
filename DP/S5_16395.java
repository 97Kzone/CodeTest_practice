package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class S5_16395 {

    static int N, K;
    static List<int[]> nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = new ArrayList<>();

        nums.add(new int[] {});
        nums.add(new int[] { 1 });
        nums.add(new int[] { 1, 1 });

        int[] now, nxt;
        for (int i = 3; i <= 30; i++) {
            now = nums.get(i - 1);
            nxt = new int[now.length + 1];
            nxt[0] = 1;
            for (int j = 1; j < now.length; j++) {
                nxt[j] = now[j - 1] + now[j];
            }
            nxt[now.length] = 1;

            nums.add(nxt);
        }

        System.out.print(nums.get(N)[K - 1]);
    }
}
