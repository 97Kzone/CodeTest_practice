package PG_Level2;

import java.util.*;

/*
* 접근법
* 1. 두 큐의 "합" 이 같아야 한다
* 2. 즉, 1개의 큐 합 = 두 큐의 전체 합 / 2 가 성립
* 3. 큐를 마구마구 돌리면서 값이 맞는 경우가 있는지 확인
*/

class Solution {
    static Queue<Integer> q1 = new ArrayDeque();
    static Queue<Integer> q2 = new ArrayDeque();
    static long s1, s2;

    public int solution(int[] queue1, int[] queue2) {
        int res = 0;

        q1.clear();
        q2.clear();

        s1 = 0;
        s2 = 0;
        // 1. 무식하지만 확실하게 값을 넣자..
        for (int i = 0; i < queue1.length; i++) {
            s1 += queue1[i];
            s2 += queue2[i];

            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }

        long std = (s1 + s2) / 2; // 목표 값

        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (s1 == std)
                return res;
            else if (s1 > std)
                s1 -= q1.poll();
            else {
                s1 += q2.peek();
                q1.offer(q2.poll());
            }

            ++res;
        }

        return -1;
    }
}
