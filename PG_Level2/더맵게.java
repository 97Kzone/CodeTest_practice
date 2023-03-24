import java.util.*;

/* 접근법
 * 1. 최소값 2개를 뽑아서 연산 => 최소 힙
 * 2. 그 값을 다시 넣어서 반복 => 최소 힙
 * 3. 최소 힙으로 구현을 해보자
 */
class 더맵게 {
    static int res, k;
    static PriorityQueue<Integer> pq;

    public int solution(int[] scoville, int K) {
        k = K;
        pq = new PriorityQueue<>();
        
        // 1. 무식하지만 q 에 전부 offer
        for (int n : scoville) pq.offer(n);
        
        res = 0;
        // 2. K 이상이 될 떄까지 돌려보자
        check();
        
        return res;
    }
    
    static void check() {
        while (pq.size() > 1) {
            if (pq.peek() >= k) return;
            
            pq.offer(pq.poll() + (pq.poll() * 2));
            res++;
        }
        
        if (pq.peek() < k) res = -1;
    }
}