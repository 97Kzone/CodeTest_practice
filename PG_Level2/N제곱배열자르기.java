package PG_Level2;

public class N제곱배열자르기 {

    class Solution {
        public int[] solution(int n, long left, long right) {
            int[] answer = new int[(int) (right - left + 1)];

            for (long i = left; i <= right; i++) {
                long j = (i / n) - (i % n);
                j = j < 0 ? 0 : j;

                long tmp = i % n + 1 + j;
                answer[(int) (i - left)] = (int) tmp;
            }

            return answer;
        }
    }
}
