package PG_Level2;

import java.util.*;

/*
 *  접근법
 *  1. 문자열이 전부 제거되는지 판단만 하면 OK
 *  2. 맞닿은 문자열이 같으면 제거 => 많이 본 패턴
 *  3. 스택을 이용하여 O(N) 으로 해결해보자
 */
public class 짝지어제거하기 {
    static char[] str;

    public int solution(String s) {
        Stack<Character> st = new Stack<>();
        str = s.toCharArray();

        st.push(str[0]); // 초기값 설정

        // 문자열을 순서대로 탐색
        for (int i = 1; i < str.length; i++) {

            // 스택이 비었으면 채워주고
            if (st.isEmpty()) {
                st.push(str[i]);
                continue;
            }

            // 맞닿은 문자열이 같으면 제거, 아니면 스택에 추가
            if (st.peek() == str[i])
                st.pop();
            else
                st.push(str[i]);
        }

        return st.isEmpty() ? 1 : 0;
    }
}
