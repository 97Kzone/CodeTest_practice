package leetcode;

class Solution {
    public int minimumBuckets(String hamsters) {
        int N = hamsters.length();
        char[] arr = hamsters.toCharArray();
        int count = 0;
        
        for (int i = 0; i < N; i++) {
            if (arr[i] != 'H') continue;
            
            if (i > 0 && arr[i - 1] == 'B') continue;
            
            if (i + 1 < N && arr[i + 1] == '.') {
                arr[i + 1] = 'B';
                count++;
                continue;
            }
            
            if (i > 0 && arr[i - 1] == '.') {
                arr[i - 1] = 'B';
                count++;
                continue;
            }
            
            return -1;
        }
        
        return count;
    }
}