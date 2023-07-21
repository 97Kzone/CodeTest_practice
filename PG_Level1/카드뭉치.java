package PG_Level1;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {

        int idx1 = 0, idx2 = 0, idx3 = 0; // cards1, cards2, goal

        while (true) {
            if (idx3 == goal.length) break;

            if (idx1 < cards1.length && goal[idx3].equals(cards1[idx1])) {
                idx1++;
                idx3++;
            } else if (idx2 < cards2.length && goal[idx3].equals(cards2[idx2])) {
                idx2++;
                idx3++;
            } else return "No";

        }

        return "Yes";
    }
}