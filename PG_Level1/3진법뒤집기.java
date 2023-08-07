package PG_Level1;

class Solution {
    public int solution(int n) {
        String num = "";
        
        while (n > 0) {
            num = (n % 3) + num;
            n /= 3;
        }
        
        StringBuilder sb = new StringBuilder(num).reverse();
        return Integer.parseInt(sb.toString(), 3);
    }
}