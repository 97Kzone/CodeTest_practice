package PG_Level1;

class Solution {
    
    static int[] cnt;
    
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        cnt = new int[number + 1];
        check(number);
        
        for (int n : cnt) {
            if (n <= limit) answer += n;
            else answer += power;
        }
        
        return answer;
    }
    
    static void check(int number) {
        int v;
        
        for (int i = 1; i <= number; i++) {
            v = 0;
            
            for (int j = 1; j * j <= i; j++) {
                if (j * j == i) v++;
                else if (i % j == 0) v += 2;
            }
            
            cnt[i] = v;
        }
    }
    
}
