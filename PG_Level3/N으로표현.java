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
        
        // 1. 초기 값
        dp[1].add(N); 
        
        // 2. 숫자 1개당 연산 4번 해보자..!
        for (int i = 2; i < 9; i++) {
            // 이전 Set의 모든 숫자들을 순회
            for (int num : dp[i-1]) {
                if (num == number) return i-1;
                
                dp[i].add(Integer.valueOf(num + "" + num));
                dp[i].add(num + N);
                dp[i].add(num - N);
                dp[i].add(num * N);
                
                if (num != 0) dp[i].add(num / N);
            }
            
            // if (dp[i].contains(number)) return i;
        }
        
        return -1;
    }
}