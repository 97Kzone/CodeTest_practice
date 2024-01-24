package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class G5_30405 {

    static int N, M;
    static List<Integer> nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new ArrayList<>();

        int k, l, r;
        String[] s;
        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            k = Integer.parseInt(s[0]);
            l = Integer.parseInt(s[1]);
            r = Integer.parseInt(s[k]);

            nums.add(l);
            nums.add(r);
        }

        Collections.sort(nums);

        System.out.print(nums.get(N-1));
    }
}
