package PG_Level2;

import java.util.*;

// O(N)으로 가능하지 않을까? with 누적합
class Solution {

    static int N;
    static long[] arr; // 1, -1 누적합
        
    public long solution(int[] sequence) {
        N = sequence.length;
        
        arr = new long[N];        
        arr[0] = sequence[0];
        
        // 누적합
        for (int i = 1; i < N; i++) {
            arr[i] = arr[i-1] + sequence[i] * (-1 * (i % 2 == 0 ? -1 : 1));
        }
        
        Arrays.sort(arr);
        return Math.max(Math.abs(arr[N-1]), 
                        Math.max(Math.abs(arr[0]), arr[N-1] - arr[0]));
    }
}