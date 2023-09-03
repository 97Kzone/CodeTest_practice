import java.util.*;

class Solution {
    
    static Map<String, String> std = new HashMap<>();
    static Map<String, Integer> profit = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        profit.put("-", 0);
        int[] answer = new int[enroll.length];
        
        // 다단계 매핑
        for (int i = 0; i < enroll.length; i++) {
            std.put(enroll[i], referral[i]);
        }

        // 수익 매핑
        for (String name : enroll) profit.put(name, 0);

        for (int i = 0; i < seller.length; i++) check(seller[i], amount[i] * 100);

        for (int i = 0; i < enroll.length; i++) answer[i] = profit.get(enroll[i]);
        
        return answer;
    }

    private void check(String sell, int price) {
        if (sell.equals("-") || price < 1) {
            return;
        }

        int myPrice = price - (price / 10);
        int passPrice = price - myPrice;
        
        profit.put(sell, profit.get(sell) + myPrice);
        check(std.get(sell), passPrice);
    }
}