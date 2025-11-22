package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class S5_9255 {

    static int N, M;
    static Set<Integer>[] graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());

        int a, b, s;
        for (int t = 1; t <= K; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            graph = new HashSet[N + 1];

            for (int i = 1; i <= N; i++) {
                graph[i] = new HashSet<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());

                graph[a].add(b);
                graph[b].add(a);
            }
            
            s = Integer.parseInt(br.readLine());
            
            List<Integer> list = new ArrayList<>(graph[s]);
            Collections.sort(list);
            
            bw.write("Data Set " + t + ":\n");
            for (int node : list) {
                bw.write(node + " ");
            }

            bw.write("\n\n");
        }

        bw.flush();
        bw.close();
    }
}