package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_17089 {

    static int N, M;
    static boolean[][] friends;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        friends = new boolean[N+1][N+1];
        cnt = new int[N+1];
        int s, e;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            friends[s][e] = true;
            friends[e][s] = true;

            cnt[s]++;
            cnt[e]++;
        }

        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if(!friends[i][j]) continue;
                for (int k = j + 1; k <= N; k++) {
                    if (!friends[k][i] || !friends[k][j]) continue;
                    res = Math.min(res, cnt[i] + cnt[j] + cnt[k] - 6);
                }
            }
        }

        System.out.print(res == Integer.MAX_VALUE ? -1 : res);
    }
}
