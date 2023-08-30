class Solution {
    
    static int answer;
    static int[] nums, select;
    
    public int solution(int[] number) {
        answer = 0;
        
        nums = number;
        select = new int[3];
        comb(0, 0);
        
        return answer;
    }
    
    static void comb(int cnt, int idx) {
        if (cnt == 3) {
            if (select[0] + select[1] + select[2] == 0) answer++;
            return;
        }
        
        for (int i = idx; i < nums.length; i++) {
            select[cnt] = nums[i];
            comb(cnt + 1, i + 1);
        }
    }
}