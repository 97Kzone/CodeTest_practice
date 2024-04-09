package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_18429 {

    static int N, K, res;
    static int[] kits;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        kits = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            kits[i] = Integer.parseInt(st.nextToken());
        }

        res = 0;
        boolean[] visit;
        for (int i = 0; i < N; i++) {
            visit = new boolean[N];
            visit[i] = true;
            check(i, 500, 1, visit);
        }

        System.out.print(res);
    }
    
    static void check(int idx, int std, int cnt, boolean[] visit) {
        if (cnt == N) {
            res++;
            return;
        }

        // 불가능한 경우
        if (std < 500)
            return;
            
        for (int i = 0; i < N; i++) {
            if (visit[i]) continue;

            visit[i] = true;
            check(i, std + kits[i] - K, cnt + 1, visit);
            visit[i] = false;
        }
    }

}
