package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_1342 {

    static String s;
    static char[] cnt;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cnt = new char[26];
        s = br.readLine();

        for (int i = 0; i < s.length(); i++)
            cnt[s.charAt(i) - 'a']++;

        res = 0;
        dfs(0, "", s.length());

        System.out.print(res);
    }

    static void dfs(int idx, String std, int l) {
        if (idx == l) {
            res++;
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (cnt[i] == 0)
                continue;

            if (std != "" && std.charAt(std.length() - 1) == (char) (i + 'a'))
                continue;

            cnt[i]--;
            dfs(idx + 1, std + (char) (i + 'a'), l);
            cnt[i]++;
        }
    }
}
