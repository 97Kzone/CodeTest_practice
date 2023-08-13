package PG_Level2;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i = 0; i < prices.length; i++)
        {
            int std = prices[i];
            int count = 0;
            for(int j = i+1; j < prices.length; j++)
            {
                count++;
                if(prices[j] < std)
                {
                    answer[i] = count;
                    break;
                }
                
            }
            answer[i] = count;
            
        }
        
        return answer;
    }
}