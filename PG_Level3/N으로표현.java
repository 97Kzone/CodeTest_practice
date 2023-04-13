import java.util.*;

/*
* 접근법
* 1. 최솟값이 9 부터는 -1 return
* 2. 대놓고 완전탐색을 요구하는 느낌
* 3. 2차원 DP를 쓰고 싶었으나 점화식을 못세워서 완탐으로 출발
*/
class Solution {
    static Set<Integer>[] dp; // 이름만 DP
    
    public int solution(int N, int number) {
        dp = new HashSet[9];    
        
        for (int i = 0; i < 9; i++) dp[i] = new HashSet<>();
        
        String tmp = N + "";  
        
        // 가능한 모든 연산을 해보자
        for (int i = 1; i < 9; i++) {

            // 초기값
            dp[i].add(Integer.valueOf(tmp.repeat(i)));
            
            for (int j = 1; j < i; j++) {
                for (int v1 : dp[j]) {
                    for (int v2 : dp[i-j]) {
                        dp[i].add(v1 + v2);
                        dp[i].add(v1 * v2);
                        dp[i].add(v1 - v2);
                        
                        if (v2 != 0) dp[i].add(v1 / v2);
                    }
                 }
            }
            if (dp[i].contains(number)) return i;
            
        }
        
        return -1;
    }
}