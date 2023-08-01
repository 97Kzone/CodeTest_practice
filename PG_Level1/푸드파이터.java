package PG_Level1;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        int n = 0;
        String s = "";
        for (int i = 1; i < food.length; i++) {
            n = food[i] / 2;
            s = String.valueOf(i).repeat(n);
            answer += s;
            sb.append(s);
        }
        
        answer += "0" + sb.reverse();
        return answer;
    }
}