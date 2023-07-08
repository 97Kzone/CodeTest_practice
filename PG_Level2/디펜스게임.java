package PG_Level2;

import java.util.*;

// 어떻게 이런 발상을 해낼 수 있을까
class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < enemy.length; i++) {
            pq.offer(enemy[i]);

            if (pq.size() > k) n -= pq.poll();
            if (n < 0) return i;
        }

        return enemy.length;
    }
}