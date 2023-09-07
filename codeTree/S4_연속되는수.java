package codeTree;

import java.util.*;

public class S4_연속되는수 {

    static List<Integer> nums;
    static Set<Integer> set;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(sc.nextInt());
        }

        set = new HashSet<>(nums);
        int result = 0;

        for (int choice : set) {
            List<Integer> std = new ArrayList<>();
            for (int num : nums) {
                if (num != choice) {
                    std.add(num);
                }
            }

            int tmp = 0;
            for (int i = 0; i < std.size() - 1; i++) {
                if (std.get(i).equals(std.get(i + 1))) {
                    tmp += 1;
                } else {
                    tmp = 0;
                }
                result = Math.max(tmp, result);
            }
        }

        System.out.println(result + 1);
    }
}
