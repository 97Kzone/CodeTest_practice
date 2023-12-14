package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class G3_1516 {

    static int N;
    static int[] time, degree;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        time = new int[N + 1];
        degree = new int[N + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        int num;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            time[i] = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()) {
                num = Integer.parseInt(st.nextToken());
                if (num == -1)
                    break;

                degree[i]++;
                graph.get(num).add(i);
            }
        }
        int[] ans = check();
        for (int i = 1; i <= N; i++) {
            sb.append(ans[i] + "\n");
        }

        System.out.print(sb.toString());
    }
    
    static int[] check() {
        Queue<Integer> q = new ArrayDeque<>();
        int[] res = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
            if (degree[i] == 0) {
                q.offer(i);
                res[i] = time[i];
            }
        }

        int std;
        while(!q.isEmpty()) {
            std = q.poll();

            for (int nxt : graph.get(std)) {
                res[nxt] = Math.max(res[nxt], res[std] + time[nxt]);
                degree[nxt]--;
                if (degree[nxt] == 0) {
                    q.offer(nxt);
                }
            }
        }   
        return res;
    }
}
