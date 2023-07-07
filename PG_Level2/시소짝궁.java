package PG_Level2;

class Solution {

    static int[] origin, dist;

    public long solution(int[] weights) {
        long answer = 0;

        origin = new int[1001];
        dist = new int[4001];

        // 가능한 모든 무게 카운트
        for (int w : weights) {
            answer += dist[w * 2];
            answer += dist[w * 3];
            answer += dist[w * 4];

            answer -= origin[w] > 0 ? origin[w] * 2 : 0;

            origin[w]++;
            dist[w * 2]++;
            dist[w * 3]++;
            dist[w * 4]++;
        }


        return answer;
    }
}