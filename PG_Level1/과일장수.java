package PG_Level1;

import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int len = score.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> (o2 - o1));

        // pq에 전부 삽입
        for (int n : score) {
            pq.offer(n);
        }

        for (int i = 1; i <= len; i++) {
            if (i % m == 0) {
                answer += pq.poll() * m;
                continue;
            }
            pq.poll();
        }

        return answer;
    }


}
