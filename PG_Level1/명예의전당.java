package PG_Level1;

import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> (o1 - o2));
        
        for (int i = 0; i < score.length; i++) {
            pq.offer(score[i]);
            
            if (pq.size() > k) pq.poll();
            answer[i] = pq.peek();
        }
        
        return answer;
    }
}