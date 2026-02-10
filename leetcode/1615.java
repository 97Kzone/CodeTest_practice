package leetcode;

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] degree = new int[n];
        boolean[][] graph = new boolean[n][n];

        int a, b;
        for (int[] r : roads) {
            a = r[0];
            b = r[1];
            degree[a]++;
            degree[b]++;
            graph[a][b] = true;
            graph[b][a] = true;
        }

        int res = 0;
        int v;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                v = degree[i] + degree[j];
                if (graph[i][j]) v--;
                res = Math.max(res, v);
            }
        }
        return res;
    }
}
