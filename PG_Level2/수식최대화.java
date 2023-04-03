package PG_Level2;

import java.util.ArrayList;
import java.util.List;
/*
*  접근법
*  1. 연산자는 *, +, - => 가능한 조합 수 3! = 6가지
*  2. 입력은 최대 길이 100 문자열, 알 수 없는 테스트 케이스 수
*  3. 6가지에 대해 전부 완전탐색해봐도 될 것 같다 ?
*/
class 수식최대화 {
    static char[][] oper = {{'*', '+', '-'}, {'*', '-', '+'}, {'+', '*', '-'}, 
                         {'+', '-', '*'}, {'-', '*', '+'}, {'-', '+', '*'}};
    
    public long solution(String expression) {
        long answer = 0;
        
        // 1. 가능한 6가지 우선순위를 전부 탐색
        long v;
        for (char[] op : oper) {
            v = check(op, 0, expression);
            answer = Math.max(Math.abs(v), answer);
        }
        
        System.out.println(answer);
        return answer;
    }
    
    static long check(char[] op, int N, String exp) {
        List<Long> std = new ArrayList<>();
        if(N == 2) {
            for (String tmp : exp.split("\\" + op[2])) {
                std.add(Long.parseLong(tmp));
            }

            return eval(op[2], std);
        }

        long res;
        if (op[N] == '*') {
            for (String tmp : exp.split("\\*")) std.add(check(op, N+1, tmp));
            res = eval('*', std);
        } else if (op[N] == '+') {
            for (String tmp : exp.split("\\+")) std.add(check(op, N+1, tmp));
            res = eval('+', std);
        } else {
            for (String tmp : exp.split("\\-")) std.add(check(op, N+1, tmp));
            res = eval('-', std);
        }

        return res;
    }
    
    // eval 처럼 사용해보자 ..
    static long eval(char c, List<Long> exp) {
        long res = exp.get(0);
        int size = exp.size();
        
        if (c == '*') {
            for (int i = 1; i < size; i++) res *= exp.get(i);
        } else if (c == '+') {
            for (int i = 1; i < size; i++) res += exp.get(i);
        } else {
            for (int i = 1; i < size; i++) res -= exp.get(i);
        }

        return res;
    }
}