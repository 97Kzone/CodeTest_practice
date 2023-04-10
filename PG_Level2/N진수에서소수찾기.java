package PG_Level2;

public class N진수에서소수찾기 {
    
    public int solution(int n, int k) {
        int answer = 0;
        
        // 1. K진수로 변환
        String s = Integer.toString(n, k);
        
        // 2. "0"을 기준으로 split()
        String[] nums = s.split("0");
        
        for (String num : nums) {
            if ("".equals(num)) continue;
            
            if(isPrime(Long.parseLong(num))) answer++;
        }
        
        return answer;
    }
    
    static boolean isPrime(long num) {
        if (num == 1) return false;
        if (num == 2) return true;
        
        int std = (int) Math.sqrt(num);
        
        for (int i = 2; i <= std; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
