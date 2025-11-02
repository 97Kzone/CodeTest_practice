package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class S1_20167 {
    static int N, K;
    static int[] arr;
    static HashMap<Integer, Integer> dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        dp = new HashMap<>();
        check();
        System.out.println(dp.getOrDefault(N, 0));
    }
    
    static void check() {
        int left = 0, right = 0, sum = 0;
        
        while (right <= N) {
            if (sum >= K) {
                while (sum >= K) {
                    int current = dp.getOrDefault(right, 0);
                    int leftValue = dp.getOrDefault(left, 0);
                    dp.put(right, Math.max(current, leftValue + sum - K));
                    
                    sum -= arr[left];
                    left++;
                }
            } else {
                int current = dp.getOrDefault(right, 0);
                int prev = dp.getOrDefault(right - 1, 0);
                dp.put(right, Math.max(current, prev));
                
                if (right == N) {
                    break;
                }
                
                sum += arr[right];
                right++;
            }
        }
    }
}
