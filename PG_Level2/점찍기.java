package PG_Level2;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long tmp = (long) Math.pow(d, 2);
        
        for (int i = 0; i*k <= d; ++i) {
            answer += (Math.floor(Math.sqrt(tmp - Math.pow(i*k, 2))) / k) + 1;
        }
        return answer;
    }
}