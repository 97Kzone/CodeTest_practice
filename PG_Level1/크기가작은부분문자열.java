package PG_Level1;

class Solution {
    public int solution(String t, String p) {
        
        int answer = 0;
        int lt = t.length();
        int pt = p.length();
        
        long np = Long.parseLong(p);
        String std = "";
        for (int i = 0; i <= lt - pt; i++) {
            std = t.substring(i, i + pt);
            
            if (Long.parseLong(std) <= np) answer++;            
        }
        
        return answer;
    }
}