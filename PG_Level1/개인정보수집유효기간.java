package PG_Level1;

import java.util.*;

class Solution {

    static Map<String, Integer> maps;
    static int now, v;

    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> res = new ArrayList<>();
        init(terms);

        now = day2int(today);

        String[] std;
        int idx = 0;
        for (String s : privacies) {
            std = s.split(" ");
            v = day2int(std[0]) + (maps.get(std[1]) * 28) - 1;

            if (v < now) res.add(idx);
            idx++;
        }
        int[] answer = new int[res.size()];
        for (int i = 0; i < res.size(); i++) answer[i] = res.get(i) + 1;

        return answer;
    }

    static int day2int(String s) {
        String[] tmp = s.split("\\.");
        return (Integer.parseInt(tmp[0]) * 28 * 12) +
                (Integer.parseInt(tmp[1]) * 28) + 
                Integer.parseInt(tmp[2]);
    }

    static void init(String[] arr) {
        maps = new HashMap<>();

        String[] tmp;
        for (String s : arr) {
            tmp = s.split(" ");
            maps.put(tmp[0], Integer.parseInt(tmp[1]));
        }

    }
}