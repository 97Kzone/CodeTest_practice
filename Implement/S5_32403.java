package Implement;

import java.util.*;
import java.io.*;

public class S5_32403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int res = 0;
        int n;
        List<Integer> list = new ArrayList<>();
        
        for (int i = 1; i <= T; i++) {
            if (T % i == 0)
            list.add(i);
        }
        
        st = new StringTokenizer(br.readLine());
        int std;
        for (int i = 0; i < N; i++) {
            n = Integer.parseInt(st.nextToken());
            std = Integer.MAX_VALUE;
            for (int num : list) {
                std = Math.min(std, Math.abs(num - n));
            }
            res += std;
        }

        System.out.print(res);
    }
}
