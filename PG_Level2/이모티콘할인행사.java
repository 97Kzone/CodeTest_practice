package PG_Level2;

import java.util.Arrays;

public class 이모티콘할인행사 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[][] users = {{40, 10000}, {25, 10000}};
        int[] emo = {7000, 9000};

        sol.solution(users, emo);
    }
}

class Solution {
    static int[] sale = {10, 20, 30, 40}; // 할인율
    static int[] cUser[], emt, select; // 선택된 할인율
    static int res1, res2; 
    public int[] solution(int[][] users, int[] emoticons) {
        

        cUser = users;
        emt = emoticons;
        res1 = 0;
        res2 = 0;
        // 할인 종류 40, 30, 20, 10
        // 이모티콘 최대 7 개
        // 가능한 경우 16000가지 => 완탐으로 해볼까?
        select = new int[emoticons.length];
        cb(0, emoticons.length);
        
        int[] answer = new int[] {res1, res2};
        return answer;
    }

    // 이모티콘별 할인율 조합을 구해보자, 중복이 가능한..
    static void cb(int cnt, int num) {
        if (cnt == num) {
            check();
            return;
        }

        for (int v : sale) {
            select[cnt] = v;
            cb(cnt + 1, num);
        }
    }

    // 할인율에 따라 계산하기, 결과값 구하기
    static void check() {

        // 0. 현재 조합의 이모티콘 가격
        int[] value = new int[emt.length];
        for (int i = 0; i < emt.length; i++) value[i] = (emt[i] * (100 - select[i])) / 100;

        int rate, std, price;
        int cnt = 0, total = 0; // total = 총 금액, cnt = 서비스 가입자

        // 1. user 마다 순회
        for (int[] user : cUser) {
            rate = user[0];
            std = user[1];
            price = 0;

            // 2. 각 이모티콘을 살까, 말까?
            for (int i = 0; i < emt.length; i++) {
                // 구매 조건 충족
                if (rate < select[i]) price += value[i];

                // 서비스 가입
                if (price >= std) {
                    cnt++;
                    price = 0;
                    break;
                }
            }
            // 미가입자는 금액을 더한다
            total += price;
        }

        if (res1 < cnt) { // 최고 가입자 갱신
            res1 = cnt;
            res2 = total;
        } 
    }
}
