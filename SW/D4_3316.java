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

            // 첫 날은 A 필참
            int std = 1 << (s.charAt(0) - 'A');
            for (int i = 1; i < 1 << 4; i++) {
                if((i & 1) == 0 || (std & i) == 0) continue; 
                dp[0][i] = 1; // 가능한 케이스
            }

            check(); // 남은 날 체크
            res = 0;
            for (int i = 1; i < 1 << 4; i++) {
                res += dp[s.length() - 1][i];
                res %= 1000000007;
            }
            sb.append("#" + t + " ").append(res + "\n");
        }
        System.out.print(sb.toString());
    }

    static void check() {
        for (int i = 1; i < s.length(); i++) {
            int std = 1 << (s.charAt(i) - 'A'); // 오늘의 관리자

            for (int j = 1; j < 1 << 4; j++) {
                if (dp[i-1][j] == 0) continue; // 이전이 불가능 case

                for (int k = 1; k < 1 << 4; k++) {
                    if ((j & k) == 0 || (k & std) == 0) continue;
                    dp[i][k] += dp[i-1][j];
                    dp[i][k] %= 1000000007;
                }
            }
        }
    }
}
