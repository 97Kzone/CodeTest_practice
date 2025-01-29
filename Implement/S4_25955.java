package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S4_25955 {

    static Map<Character, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        init();
        int N = Integer.parseInt(br.readLine());

        String[] words = new String[N];
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            public int compare(String o1, String o2) {
                if (o1.charAt(0) == o2.charAt(0)) {
                    int num1 = Integer.parseInt(o1.substring(1));
                    int num2 = Integer.parseInt(o2.substring(1));
                    return Integer.compare(num2, num1);
                } else {
                    return map.get(o1.charAt(0)) - map.get(o2.charAt(0));
                }
            };
        });

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            words[i] = st.nextToken();
            pq.offer(words[i]);
        } 

        String now;
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            now = pq.poll();
            if (words[i].equals(now)) continue;

            if (!flag) {
                sb.append("KO" + "\n");
                flag = true;
            }
            sb.append(now + " ");
        }

        if (!flag) sb.append("OK");
        System.out.print(sb.toString());
    }

    static void init() {
        map = new HashMap<>();
        map.put('B', 0);
        map.put('S', 1);
        map.put('G', 2);
        map.put('P', 3);
        map.put('D', 4);
    }
}
