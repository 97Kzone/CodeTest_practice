package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class S4_32205 {

    static int N;
    static Set<Integer> edges;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 

        N = Integer.parseInt(br.readLine());
        edges = new HashSet<>();
        
        int a, b, c;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            
            if (edges.contains(a) || edges.contains(b) || edges.contains(c)) {
                System.out.println(1);
                return;
            } else {
                edges.add(a);
                edges.add(b);
                edges.add(c);
            }
        }
        
        System.out.println(0);
    }
}