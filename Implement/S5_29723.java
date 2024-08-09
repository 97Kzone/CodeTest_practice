package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S5_29723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();

        String word;
        int score;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            word = st.nextToken();
            score = Integer.parseInt(st.nextToken());

            map.put(word, score);
        }

        int res = 0;
        int std = M - K;
        for (int i = 0; i < K; i++) {
            word = br.readLine();
            res += map.get(word);
            map.remove(word);
        }
    
        List<Integer> max = new ArrayList<>(map.values());
        List<Integer> min = new ArrayList<>(map.values());
        Collections.sort(max, Collections.reverseOrder());
        Collections.sort(min);

        int v1 = 0;
        int v2 = 0;
        for (int i = 0; i < std; i++) {
            v1 += max.get(i);
            v2 += min.get(i);
        }

        System.out.println((res + v2) + " " + (res + v1));
    }
}
