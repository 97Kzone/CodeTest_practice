package leetcode;

class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        int v;
        for (int num : nums) {
            v = check(num);
            map.putIfAbsent(v, new ArrayList<>());
            map.get(v).add(num);
        }

        int res = -1;
        for (List<Integer> list : map.values()) {
            if (list.size() < 2) continue;

            Collections.sort(list, Collections.reverseOrder());

            res = Math.max(res, list.get(0) + list.get(1));
        }

        return res;
    }

    static int check(int n) {
        int res = 0;

        while (n > 0) {
            res += n % 10;
            n /= 10;
        }

        return res;
    }
}
