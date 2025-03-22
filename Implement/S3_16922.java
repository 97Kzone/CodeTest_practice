package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class S3_16922 {

    static int N;
    static int[] nums = {1, 5, 10, 50};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        N = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();
        int l, v;
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N - i; j++) {
                for (int k = 0; k <= N-i-j; k++) {
                    l = N - i - j - k;
                    v = 1*i + 5*j + 10*k + 50*l; 
                    set.add(v);
                }
            }
        }

        System.out.print(set.size());
    }
}
