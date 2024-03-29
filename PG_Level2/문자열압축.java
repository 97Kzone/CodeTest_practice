package PG_Level2;

import java.lang.Math;

/*
 * 접근법
 * 1. 문자열 s 의 최대길이 1000, 완전탐색(N^2) 100만 <= 1초
 * 2. 완전탐색으로 그냥 되는 길이 다 잘라본다
 * 3. BUT, 압축하려면 최소 "2등분" 되어야 의미 있으니 유의하자
 */

class Solution {
    static int res, size;
    static String input;

    public int solution(String s) {
        if (s.length() == 1) { // 미리 싹을 자르자
            return 1;
        }

        size = s.length();
        input = s;
        res = 1001; // 최대 길이 1000

        // 완전탐색
        for (int i = 1; i <= size / 2; i++)
            check(i);

        return res;
    }

    static void check(int l) {
        int cnt = 1;
        StringBuilder sb = new StringBuilder();

        int e;
        String tmp = input.substring(0, l);
        for (int i = l; i < size; i += l) {
            e = i + l >= size ? size : i + l;

            if (tmp.equals(input.substring(i, e)))
                cnt++;
            else {

                if (cnt < 2)
                    sb.append(tmp);
                else
                    sb.append(cnt + tmp);

                tmp = input.substring(i, e);
                cnt = 1;
            }
        }

        // 잔반처리
        if (cnt < 2)
            sb.append(tmp);
        else
            sb.append(cnt + tmp);

        res = Math.min(res, sb.length());
    }
}