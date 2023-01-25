package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G3_1967 {
    static int N, res;
    static boolean[] check;
    static ArrayList<Node>[] graph;
    
    static class Node {
        int idx;
        int w;

        Node (int idx, int w) {
            this.idx = idx;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        
        // 인접 리스트
        for (int i = 0; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        } 
        
        // 입력이 N-1개.. 불편하네
        int s, e, v;
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            graph[s].add(new Node(e, v));
            graph[e].add(new Node(s, v));
        }

        res = 0; 
        for (int i = 1; i < N+1; i++) {
            check = new boolean[N+1];
            check[i] = true;
            dfs(i, 0);
        } 

        System.out.println(res);
    }
    
    static void dfs(int idx, int v) {
        for (Node node : graph[idx]) {
            if (!check[node.idx]) {
                check[node.idx] = true;
                dfs(node.idx, v + node.w);
            }
        }

        res = (res < v) ? v : res;
    }
}
