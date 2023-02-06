package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class S4_1620 {
    static HashMap<String, String> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        String s;
        map = new HashMap<>();

        for (int i = 1; i < N+1; i++) {
            s = br.readLine();
            map.put(s, String.valueOf(i));
            map.put(String.valueOf(i), s);
        }
        
        for (int i = 0; i < M; i++) {
            System.out.println(map.get(br.readLine()));
        }
    }
}
