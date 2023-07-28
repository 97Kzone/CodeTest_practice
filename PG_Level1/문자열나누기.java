package PG_Level1;

class Solution {
    public int solution(String s) {
        int answer = 0;
        char std = s.charAt(0);
        int cnt1 = 1, cnt2= 0;

        for (int i = 1; i < s.length(); i++) {
            if (cnt1 == cnt2) {
                answer++;
                cnt1 = 1;
                cnt2 = 0;
                std = s.charAt(i);
                continue;
            }
            
            if (std == s.charAt(i)) cnt1++;
            else cnt2++;
        }
        
        return answer + 1;
    }
}