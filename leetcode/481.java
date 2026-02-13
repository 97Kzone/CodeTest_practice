package leetcode;

class Solution {
    public int magicalString(int n) {
        if (n <= 0) return 0;
        if (n <= 3) return 1; 

        int[] s = new int[n + 2]; 
        s[0] = 1;
        s[1] = 2;
        s[2] = 2;

        int ones = 1;     
        int read = 2;     
        int write = 3;   
        int next = 1;     

        int cnt;
        while (write < n) {
            cnt = s[read]; 
            for (int k = 0; k < cnt && write < n; k++) {
                s[write] = next;
                if (next == 1) ones++;
                write++;
            }

            next = (next == 1) ? 2 : 1;
            read++;
        }

        return ones;
    }
}