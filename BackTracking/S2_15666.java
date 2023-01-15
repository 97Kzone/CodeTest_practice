package BackTracking;

import java.util.*;

public class S2_15666 {
    static int N, M;
    static int[] std;
    static ArrayList<Integer> res;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        Set<Integer> nums = new HashSet<>();
        for (int i=0; i<N; i++) {
            nums.add(sc.nextInt());
        }
        std = new int[nums.size()];
        int idx = 0;

        res = new ArrayList<>();
        for (int num : nums) {
            std[idx++] = num;
        }
        Arrays.sort(std);
        check(0);
    }

    static void check(int v) {
        if (v == M) {
            String tmp = "";
            for (int n : res) {
                tmp += Integer.toString(n) + " "; 
            }
            System.out.println(tmp);
            return;
        }

        for (int i=0; i<std.length; i++) {
            if (v == 0 || res.get(res.size()-1) <= std[i]) {
                res.add(std[i]);
                check(v+1);
                res.remove(res.size()-1);
            }        
        }
    }
}
