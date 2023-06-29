package PG_Level2;

import java.util.*;

// 일단 완탐
class Solution {
    static int answer = 100000000;

    public int solution(int storey) {
        check(storey);
        return answer;
    }

    static void check(int v) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {v, 0});

        while(!q.isEmpty()) {
            int[] now = q.poll();

            int std = now[0] % 10;

            if (now[0] < 10) {
                answer = Math.min(answer, now[0] + now[1]);
                answer = Math.min(answer, now[1] + (10 - now[0]) + 1);
                continue;
            }

            if (std == 0) {
                q.offer(new int[] {now[0] / 10, now[1]});
                continue;
            }
            q.offer(new int[] {now[0]/10, now[1] + std});
            q.offer(new int[] {now[0]/10 + 1, now[1] + (10 - std)});
        }

    }
}