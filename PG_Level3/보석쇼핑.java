import java.util.*;

/*
* 접근법
* 1. 보석의 종류를 파악한다
* 2. 최소길이를 찾기위해 슬라이딩 윈도우 
*/
public class 보석쇼핑 {
    static Set<String> kind = new HashSet<>();
    static Map<String, Integer> pick = new HashMap<>();
    
    public int[] solution(String[] gems) {
        kind.clear();
        pick.clear();
    
        // 보석 종류 체크
        for (String gem : gems) kind.add(gem); 
        int size = kind.size();
        
        // 크기가 1이면 따질게 없다
        if (size == 1) return new int[]{1, 1};
        
        // 쇼핑 시작
        int l = 0, r = 1;
        pick.put(gems[0], 1);
        
        String gem;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[0] - o2[0]));
        while (l < gems.length) {
            
            // 모든 종류를 담았다면
            if (pick.size() == size) {
                pq.offer(new int[] {r-l+1, l, r});
                
                pick.put(gems[l], pick.get(gems[l]) - 1);
                if (pick.get(gems[l]) == 0) pick.remove(gems[l]);
                l++;
            } else {
                if (r == gems.length) break;
                
                pick.put(gems[r], pick.getOrDefault(gems[r], 0) + 1);
                r++;
            }
        }
        int[] answer = pq.poll();
        return new int[] {answer[1] + 1, answer[2]};
    }
}
