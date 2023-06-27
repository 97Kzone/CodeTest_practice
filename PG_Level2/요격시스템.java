package PG_Level2;
import java.util.*;

class Solution {
    
    public int solution(int[][] targets) {
        Arrays.sort(targets, (o1, o2) -> (o1[1] - o2[1]));
        
        int s, e;
        int res = 0, std = 0;
        for (int i = 0; i < targets.length; i++) {
            s = targets[i][0];
            e = targets[i][1];
            
            if (s < std) continue;
            
            if (e > std) {
                std = e;
                res++;
            }
        }
        
        return res;
    }
}