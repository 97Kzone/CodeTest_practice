package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_28238 {
    static final int MAX_N = 1000000;
    static int[][] nums = new int[MAX_N][5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] ans = {-1, -1};
        int ansMx = -1;
        
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                int cnt = 0;
                for (int k = 0; k < n; k++) {
                    if (nums[k][i] == 1 && nums[k][j] == 1) {
                        cnt++;
                    }
                }
                if (cnt > ansMx) {
                    ansMx = cnt;
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }

        System.out.println(ansMx);
        for (int i = 0; i < 5; i++) {
            if (i == ans[0] || i == ans[1]) {
                System.out.print(1 + " ");
            } else {
                System.out.print(0 + " ");
            }
        }
    }
}
