package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_14654 {

    static int res1, res2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] nums = new int[N][2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i][0] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i][1] = Integer.parseInt(st.nextToken());
        }

        int win = 0; 
        int cnt = 0, ans = 0;
        for (int i = 0; i < N; i++) {
            int res = isWin(nums[i][0], nums[i][1]);
            if (res == 0) res = -1 * win;
            if (res == win) {
                cnt++;
            } else {
                cnt = 1;
                win = res;
            }
            ans = Math.max(cnt, ans);
        }
        System.out.print(ans);
    }

    static int isWin(int a, int b) {
        if (a == b) return 0;
        switch (a) {
            case 1:
                if (b == 2) return 1;
                if (b == 3) return -1;
                break;
            case 2:
                if (b == 1) return -1;
                if (b == 3) return 1;
                break;
            case 3:
                if (b == 1) return 1;
                if (b == 2) return -1;
        }
        return 0;
    }
}
