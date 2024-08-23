package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class S5_14646 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int res = 0;

        Set<Integer> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        int n;
        for (int i = 0; i < N*2; i++) {
            n = Integer.parseInt(st.nextToken());

            if (set.contains(n)) set.remove(n);
            else set.add(n);

            res = Math.max(res, set.size());
        }
        
        System.out.print(res);
    }
}
