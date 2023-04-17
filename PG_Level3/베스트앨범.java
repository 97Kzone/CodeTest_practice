import java.util.*;

class Solution {
    static Map<String, Integer> total; // 장르별 재생 총합
    static Map<String, List<int[]>> songs; // 장르별 노래 정리
    
    public int[] solution(String[] genres, int[] plays) {
        total = new HashMap<>();
        songs = new HashMap<>();
        
        // 1. 수록곡을 돌면서 전처리 작업
        for (int i = 0; i < genres.length; i++) {
            
            // 장르별 재생 수 정리
            List<int[]> tmp = songs.getOrDefault(genres[i], new ArrayList<>());
            tmp.add(new int[] {i, plays[i]});
            songs.put(genres[i], tmp);
            
            // 총합 계산
            total.put(genres[i], total.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<Integer> std = new ArrayList<>(); // 총 몇 곡이 나올지 모르니 List
        
        // 2. 장르별 정렬
        List<String> keys = new ArrayList<>(total.keySet());
        Collections.sort(keys, (o1, o2) -> (total.get(o2) - total.get(o1)));
            
        List<int[]> tmp = new ArrayList<>();
        int size = 0;
        // 3. 장르별로 최대 2곡씩 뽑아서 목록에 삽입
        for (String key : keys) {
            tmp = songs.get(key);
            Collections.sort(tmp, (o1, o2) -> (o2[1] - o1[1]));
            
            size = tmp.size() > 1 ? 2 : tmp.size();
            for (int i = 0; i < size; i++) std.add(tmp.get(i)[0]);
        }

        int[] answer = new int[std.size()];
        for (int i = 0; i < std.size(); i++) answer[i] = std.get(i); 
        
        return answer;

    }
}