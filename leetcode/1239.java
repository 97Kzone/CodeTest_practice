package leetcode;

class Solution {
    
    int[] bits;
    int[] len;
    int N;
    int res = 0;

    public int maxLength(List<String> arr) {
        N = arr.size();
        bits = new int[N];
        len = new int[N];

        int validCnt = 0;
        String s;
        int bit, c;
        boolean flag;
        for (int i = 0; i < N; i++) {
            s = arr.get(i);
            bit = 0;
            flag = true;

            for (int j = 0; j < s.length(); j++) {
                c = 1 << (s.charAt(j) - 'a');
                if ((bit & c) != 0) {  
                    flag = false;
                    break;
                }
                bit |= c;
            }

            if (flag) {
                bits[validCnt] = bit;
                len[validCnt] = s.length();
                validCnt++;
            }
        }

        N = validCnt;  

        check(0, 0, 0);

        return res;
    }

    void check(int idx, int state, int sum) {
        res = Math.max(res, sum);

        for (int i = idx; i < N; i++) {
            if ((state & bits[i]) == 0) {
                check(i + 1, state | bits[i], sum + len[i]);
            }
        }
    }
}