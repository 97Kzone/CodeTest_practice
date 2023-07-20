package PG_Level1;

import java.util.*;

class Solution {

    static Map<String, Integer> map;

    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        map = new HashMap<>();

        String[] std;
        int cnt;
        // 1. 최소회수를 전부 카운트 해보자!
        for (String k : keymap) {
            std = k.split("");
            for (int i = 0; i < std.length; i++) {
                cnt = map.getOrDefault(std[i], 1000);

                // 최저 회수 갱신
                if (i + 1 < cnt) map.put(std[i], i + 1);
            }
        }

        int v;
        boolean flag;
        // 2. 하나씩 따져보자
        for (int i = 0; i < targets.length; i++) {
            cnt = 0;
            std = targets[i].split("");
            flag = true;
            for (String s : std) {
                v = map.getOrDefault(s, -1);
                if (v == -1) {
                    answer[i] = -1;
                    flag = false;
                    break;
                } else cnt += v;
            }
            if (flag) answer[i] = cnt;
        }
        return answer;
    }
}