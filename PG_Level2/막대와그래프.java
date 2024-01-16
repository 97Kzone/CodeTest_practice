package PG_Level2;

import java.util.*;

public class 막대와그래프 {
    static int[][] degree;
    static int[] answer;
    static List<List<Integer>> graph;

    public int[] solution(int[][] edges) {
        answer = new int[4];
        degree = new int[10000001][2];

        // 1. 그래프 생성
        graph = new ArrayList<>();
        for (int i = 1; i <= 1000000; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            degree[edge[0]][0]++;
            degree[edge[1]][1]++;
            graph.get(edge[0]).add(edge[1]);
        }

        for (int i = 1; i <= 1000000; i++) {
            if (degree[i][1] == 0 && degree[i][0] > 1) {
                answer[0] = i;
                break;
            }
        }

        List<Integer> tmp = graph.get(answer[0]);
        for (int idx : tmp) {
            check(idx);
        }

        return answer;
    }

    static void check(int idx) {
        Queue<Integer> q = new ArrayDeque();
        q.offer(idx);
        boolean flag = false;

        int now;
        while (!q.isEmpty()) {
            now = q.poll();

            if (now == idx && flag) {
                answer[1]++;
                return;
            }

            if (graph.get(now).size() >= 2) {
                answer[3]++;
                return;
            }

            for (int nxt : graph.get(now)) {
                q.offer(nxt);
            }

            flag = true;
        }

        answer[2]++;
    }
}
