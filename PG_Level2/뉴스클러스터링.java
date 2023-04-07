package PG_Level2;

import java.util.*;

/*
* 접근법
* 1. 설명은 무지성 Set을 쓰면 안될 것 처럼 보인다
* 2. 조건에 맞춰 문자열 자르고 List에 저장
* 3. 교집합, 합집합의 크기를 구하여 연산해보자!
*/

class Solution {
    static List<String> s1 = new ArrayList<>();
    static List<String> s2 = new ArrayList<>();
    public int solution(String str1, String str2) {
        int answer = 0;
        
        // 초기화
        s1.clear();
        s2.clear();
        
        // 1. 무식하게 모든 원소 짤라서 넣기
        splitAndPush(str1, 1);
        splitAndPush(str2, 2);
        
        // 2. 교집합, 합집합 크기 구하기
        Set<String> tmp = new HashSet<>();
        tmp.addAll(s1);
        tmp.addAll(s2);
        
        int inter = 0; // 교집합 크기
        int union = 0; // 합집합 크기
        
        for (String s : tmp) {
            int c1 = Collections.frequency(s1, s);
            int c2 = Collections.frequency(s2, s);
            
            inter += Math.min(c1, c2);
            union += Math.max(c1, c2);
        }
        
        if (union == 0) return 65536;
        else {
            double v = (double) inter / (double) union;
            answer = (int) (v * 65536);
        }
        return answer;
    }
    
    // 자르고 Set 삽입
    static void splitAndPush(String str, int n) {
        String tmp;

        for (int i = 0; i < str.length() - 1; i++) {
            tmp = str.substring(i, i+2).replaceAll("[^a-zA-Z]", "").toLowerCase(); 

            if (tmp.length() <= 1) continue;
            if (n == 1) s1.add(tmp);
            else s2.add(tmp);
        }
    }
}