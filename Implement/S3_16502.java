package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S3_16502 {

    static int T, M;
    static double[] res;
    static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        init();

        String s, e;
        double p;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            s = st.nextToken();
            e = st.nextToken();
            p = Double.parseDouble(st.nextToken());

            graph[s.charAt(0) - 'A'].add(new Node(e.charAt(0) - 'A', p));
        }

        for (int i = 0; i < 4; i++) {
            dfs(i, 0.25, 0);
        }

        System.out.printf("%.3f\n", res[0]);
        System.out.printf("%.3f\n", res[1]);
        System.out.printf("%.3f\n", res[2]);
        System.out.printf("%.3f\n", res[3]);
    }

    static void init() {
        res = new double[4];
        graph = new ArrayList[4];
        for (int i = 0; i < 4; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    static void dfs(int now, double p, int cnt) {
        if (cnt == T) {
            res[now] += p * 100;
            return;
        }

        for (Node node : graph[now]) {
            dfs(node.first, p * node.second, cnt + 1);
        }
    }

    static class Node {
        int first;
        double second;

        Node(int first, double second) {
            this.first = first;
            this.second = second;
        }
    }
}
