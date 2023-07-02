package PG_Level2;

import java.util.*;

class Solution {
    static int N, M;
    static int[] res;

    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        N = n;
        M = m;
        res = new int[balls.length];

        List<int[]> moveBall = new ArrayList<>();
        int dist, idx = 0;
        // 1. 대칭 이동 체크
        for (int[] ball : balls) {
            moveBall.clear();

            if (!(startX == ball[0] && startY > ball[1])) moveBall.add(new int[] {ball[0], -ball[1]});
            if (!(startX == ball[0] && startY < ball[1])) moveBall.add(new int[] {ball[0], 2 * N - ball[1]});
            if (!(startY == ball[1] && startX > ball[0])) moveBall.add(new int[] {-ball[0], ball[1]});
            if (!(startY == ball[1] && startX < ball[0])) moveBall.add(new int[] {2 * M - ball[0], ball[1]});

            dist = 100000000;
            for (int[] mb : moveBall) {
                dist = Math.min(dist, check(startX, startY, mb));
            }

            res[idx++] = dist;
        }

        return res;
    }

    static int check(int x, int y, int[] ball) {
        return (int) Math.pow(x - ball[0], 2) + (int) Math.pow(y - ball[1], 2);
    }
}
