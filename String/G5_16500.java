package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class G5_16500 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[101];
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (dp[j] == 1) {
                    if (set.contains(s.substring(i, j))) {
                        dp[i] = 1;
                    }
                }
            }

            if (set.contains(s.substring(i))) {
                dp[i] = 1;
            }
        }

        System.out.print(dp[0]);
    }
}
