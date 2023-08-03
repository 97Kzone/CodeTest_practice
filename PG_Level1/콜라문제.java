package PG_Level1;

class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        int v;
        while (true) {
            // 더 이상 나눌게 없을 때
            if (n < a) break;
            
            v = n / a;
            n = n % a;
            
            answer += v * b;
            n += v * b;
        }
        
        return answer;
    }
}