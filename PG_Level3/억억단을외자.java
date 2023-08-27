import java.util.*;

class Solution {
    public int[] solution(int e, int[] starts) {
        int[] dpCount = new int[e + 1];
        
        for (int div = 2; div <= e; div++) {
            for (int jump = 0; jump <= e; jump += div) {
                dpCount[jump] += 2;
            }
        }
        
        int std = (int) Math.sqrt(e);
        for (int i = 1; i <= std; i++) dpCount[i * i] += 1;
        
        int[] dpDiv = new int[e + 1];
        int maxCount = 0;
        
        for (int idx = e; idx > 0; idx--) {
            if (maxCount <= dpCount[idx]) {
                maxCount = dpCount[idx];
                dpDiv[idx] = idx;
            } else {
                dpDiv[idx] = dpDiv[idx + 1];
            }
        }
        
        int[] result = new int[starts.length];
        for (int i = 0; i < starts.length; i++) {
            result[i] = dpDiv[starts[i]];
        }

        return result;
    }
}