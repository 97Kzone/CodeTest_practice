import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D4_3316 {
    static int res;
    static String s;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            s = br.readLine();
            dp = new int[s.length()][1 << 4]; 

            //1일차는 A 필참
            int std = 1 << (s.charAt(0) - 'A');
            for (int i = 1; i < 16; i ++) {
                if ((i & std) == 0 || (i & 1) == 0) continue;
                dp[0][i] = 1;
            }

            check();

            res = 0;
            for (int i = 1; i < 16; i++) {
                res += dp[s.length() - 1][i];
                res %= 1000000007;
            }

            sb.append("#" + t + " ").append(res + "\n");
        }
        System.out.println(sb.toString());
    }

    static void check() {
        int std;
        for (int i = 1; i < s.length(); i++) {
            std = 1 << (s.charAt(i) - 'A');

            for (int j = 1; j < 16; j++) {
                if (dp[i-1][j] == 0) continue; // 전날이 불가능한 경우 PASS
                
                for (int k = 1; k < 16; k++) {
                    if ((k & std) == 0 || (k & j) == 0) continue; 

                    dp[i][k] += dp[i-1][j];
                    dp[i][k] %= 1000000007;
                }
            }
        }
    }
}
