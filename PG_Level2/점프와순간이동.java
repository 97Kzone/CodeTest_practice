package PG_Level2;

public class 점프와순간이동 {
    public int solution(int n) {
        int ans = 0;
        while (true) {
            if (n == 0) break;
            
            if (n % 2 == 1) ans += 1;
            
            n /= 2;
        }
        return ans;
    }
}
