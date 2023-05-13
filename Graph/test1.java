package Graph;

import java.util.*;
import java.io.*;


public class test1 {
    static int N, M;
    static Set<Character>[] count;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        count = new HashSet[M];
        
        for (int i = 0; i < M; i++) count[i] = new HashSet<>();

        String s;
        for (int i = 0; i < N; i++) {
            s = br.readLine();
            for (int j = 0; j < M; j++) {
                if (s.charAt(j) == '.') continue;
                count[i].add(s.charAt(j));
            }
        }
        int res = 0;
        for (int i = 0; i < M; i++) {
            System.out.println(count[i].size());
            if (res < count[i].size()) res = count[i].size();
        } 
        System.out.println(res);
    }
}