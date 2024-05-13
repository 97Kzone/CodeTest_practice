package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class S4_9324 {

    static Map<String, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        map = new HashMap<>();

        String[] word;
        boolean flag;
        int idx, v;
        for (int t = 0; t < T; t++) {
            word = br.readLine().split("");
            map.clear();
            flag = true;
            map.put(word[0], 1);
            idx = 1;
            
            while (idx < word.length) {
                v = map.getOrDefault(word[idx], 0);

                if (v == 2) {
                    if (idx == word.length - 1 || !word[idx].equals(word[idx + 1])) {
                        sb.append("FAKE" + "\n");
                        flag = false;
                        break;
                    } else {
                        map.put(word[idx], 0);
                        idx++;
                    }
                } else {
                    map.put(word[idx], v + 1);
                }
                idx++;
            }
            if (flag) {
                sb.append("OK" + "\n");
            }
        }

        System.out.print(sb);
    }
}
