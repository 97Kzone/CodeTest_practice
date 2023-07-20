

import java.util.*;

// 이분탐색 문제인가
class Solution {

    public int solution(int[][] scores) {
        int answer = 1;
        int N = scores.length;
        int a = scores[0][0], b = scores[0][1];

        Arrays.sort(scores, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            else return o2[0] - o1[0];
        });

        int sa, sb;
        int std = 0 ;
        for (int[] s : scores) {
            sa = s[0];
            sb = s[1];
            if (a < sa && b < sb) return -1;

            if (std <= sb) {
                std = sb;

                if (a + b < sa + sb) answer += 1;
            }
        }   

        return answer;
    }

}