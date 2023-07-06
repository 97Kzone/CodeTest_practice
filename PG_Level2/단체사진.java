package PG_Level2;

class Solution {

    static String[] ch = {"A", "C", "F", "J", "M", "N", "R", "T"};
    static String[] datas;
    static boolean[] used;
    static int answer;

    public int solution(int n, String[] data) {
        answer = 0;
        datas = data;
        used = new boolean[8];

        perm("");

        return answer;
    }

    static void perm(String s) {

        if (s.length() == 8) {
            if(check(s)) answer++;
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (used[i]) continue;

            used[i] = true;
            perm(s + ch[i]);
            used[i] = false;

        }
    }

    static boolean check(String s) {

        for (String data : datas) {
            int p1 = s.indexOf(data.charAt(0)); 
            int p2 = s.indexOf(data.charAt(2)); 
            char op = data.charAt(3);
            int idx = (data.charAt(4) -'0') + 1;

            if (op == '=') {
                if (!(Math.abs(p1 - p2) == idx)) return false;
            } else if (op == '>') {
                if (!(Math.abs(p1 - p2) > idx)) return false;
            } else if (op == '<') {
                if (!(Math.abs(p1 - p2) < idx)) return false;
            }
        }

        return true;
    }
}