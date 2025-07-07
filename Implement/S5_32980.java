package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S5_32980 {

    static int N;
    static Map<Character, Integer> costMap;
    static List<Map<Character, Integer>> list;
    static char[] std = {'P', 'C', 'V', 'S', 'G', 'F', 'O'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            Map<Character, Integer> charCount = new HashMap<>();
            for (char c : ch) {
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            }
            list.add(charCount);
        }

        costMap = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            costMap.put(std[i], Integer.parseInt(st.nextToken()));
        }

        costMap.put('O', Integer.parseInt(br.readLine())); 

        long total = 0;
        for (Map<Character, Integer> item : list) {
            int amount = 0;
            char key = ' ';
            int cost;

            if (item.size() == 1) {
                for (Character c : item.keySet()) {
                    key = c;
                    amount = item.get(c);
                }
                cost = Math.min(costMap.get(key) * amount, costMap.get('O') * amount);
            } else {
                for (Character c : item.keySet()) {
                    amount += item.get(c);
                }
                cost = costMap.get('O') * amount;
            }

            total += cost;
        }

        System.out.println(total);
    }
}
