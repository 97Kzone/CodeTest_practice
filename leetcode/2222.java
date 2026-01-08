package leetcode;

class Solution {
    public long numberOfWays(String s) {
        int N = s.length();
        char[] list = s.toCharArray();

        int totalZero = 0, totalOne = 0;
        for (int i = 0; i < N; i++) {
            if (list[i] == '0') totalZero++;
            else totalOne++;
        }

        long res = 0;
        int leftZero = 0, leftOne = 0;

        for (int j = 0; j < N; j++) {
            int rightZero = totalZero - leftZero - (list[j] == '0' ? 1 : 0);
            int rightOne = totalOne - leftOne - (list[j] == '1' ? 1 : 0);

            if (list[j] == '1') {
                res += (long) leftZero * rightZero;
            } else {
                res += (long) leftOne * rightOne;
            }

            if (list[j] == '0') leftZero++;
            else leftOne++;
        }

        return res;

    }
}