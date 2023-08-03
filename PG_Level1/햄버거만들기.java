package PG_Level1;

import java.util.*;

// 슬라이딩 윈도우로 찾기
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        int len = ingredient.length;
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < len; i++) {
            st.push(ingredient[i]);
            
            if (st.size() >= 4) {
                
                if (st.get(st.size() - 4) == 1 &&
                    st.get(st.size() - 3) == 2 &&
                    st.get(st.size() - 2) == 3 &&
                    st.get(st.size() - 1) == 1) {

                    st.pop();
                    st.pop();
                    st.pop();
                    st.pop();
                    answer++;
                }            
            }
        }
        
        return answer;
    }
}