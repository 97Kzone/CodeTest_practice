package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_8362 {
    static int N, M;
    static int[] nums;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        nums = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(nums);
        
        int result = Integer.MAX_VALUE;
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int apple = Integer.parseInt(st.nextToken());
            int dist = check(apple);
            
            if (dist == 0) {
                result = 0;
                break;
            }
            
            result = Math.min(result, dist);
        }
        
        System.out.print(result);
    }
    
    static int check(int target) {
        int idx = Arrays.binarySearch(nums, target);
        if (idx >= 0) return 0;
        
        idx = -idx - 1;
        
        int minDist = Integer.MAX_VALUE;

        if (idx < N) minDist = Math.min(minDist, Math.abs(nums[idx] - target));
        if (idx > 0) minDist = Math.min(minDist, Math.abs(nums[idx - 1] - target));
        
        return minDist;
    }
}