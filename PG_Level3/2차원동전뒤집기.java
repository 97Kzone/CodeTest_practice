class Solution {
    public int solution(int[][] beginning, int[][] target) {
        int answer = 0;
        int m = beginning.length;
        int n = beginning[0].length;
        int[][] table = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                table[i][j] = beginning[i][j] ^ target[i][j];
            }
        }

        int cnt = 0;

        for (int i = 1; i < m; i++) {
            boolean isEqual = true;
            boolean isInverseEqual = true;

            for (int j = 0; j < n; j++) {
                if (table[i][j] != table[0][j]) {
                    isEqual = false;
                }
                if ((table[i][j] ^ 1) != table[0][j]) {
                    isInverseEqual = false;
                }
            }

            if (!isEqual) {
                cnt++;
                if (!isInverseEqual) {
                    return -1;
                }
            }
        }

        int sum = 0;
        for (int j = 0; j < n; j++) {
            sum += table[0][j];
        }

        answer = Math.min(cnt + sum, (m - cnt) + (n - sum));
        return answer;
    }
}