package PG_Level2;

class Solution {
    public String solution(String number, int k) {
        StringBuilder s = new StringBuilder();
        
        int count = number.length() - k;
        int right = number.length() - count;
        int left = 0, std = 0;
        while(count > 0)
        {
            int max = -1;
            for(int i = left; i <= right; ++i)
            {
                int num = number.charAt(i) - '0';
                if(num > max)
                {
                    max = num;
                    std = i;
                }
            }
            s.append(number.charAt(std));
            right = number.length() - --count;
            left = std + 1;
            
        }
        return s.toString();
    }
}