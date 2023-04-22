package PG_Level2;

import java.util.*;

/*
* 접근법
* 1. "순서"가 보장 되어야 한다 => 크기 순 정렬
* 2. 1의 규칙을 반드시 준수한다
*/
class Solution {
    List<int[]> arr = new ArrayList<>(); 
    List<Integer> nums = new ArrayList<>();
    public int[] solution(String s) {    
        arr.clear();
        nums.clear();
        
        s = s.substring(2, s.length() - 2);
        String[] tmp = s.replace("{", "").split("},");
        for (String v : tmp) {
            String[] t = v.split(",");
            int[] std = new int[t.length];
            
            for (int i = 0; i < t.length; i++) {
                std[i] = Integer.parseInt(t[i]);
            }
            arr.add(std);
        }
        
        arr.sort((o1, o2) -> (o1.length - o2.length));
        for (int[] num : arr) {
            for (int n : num) {
                if (!nums.contains(n)) nums.add(n);
            }
        }
        
        int[] res = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            res[i] = nums.get(i);
        }
        return res;
    }
}