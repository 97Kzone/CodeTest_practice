package Implement;

import java.util.*;
import java.io.*;

public class S4_24431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int n, L, F;

        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            F = Integer.parseInt(st.nextToken());

            list.clear();
            set.clear();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                list.add(st.nextToken());
            }
            
            String word1, word2;
            String std;
            for (int i = 0; i < n-1; i++) {
                word1 = list.get(i);

                if (set.contains(word1)) continue;

                std = word1.substring(L - F);
                for (int j = i + 1; j < n; j++) {
                    word2 = list.get(j);
                    if (set.contains(word2))
                        continue;

                    if (word2.endsWith(std)) {
                        set.add(word1);
                        set.add(word2);
                        break;
                    }

                }
            }
            sb.append(set.size() / 2 + "\n");
        }
        System.out.print(sb);
    }
}
