package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_12101 {

    static int N, K, cnt;
    static String res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        cnt = 1; // 순번

        res = "";
        for (int i = 1; i <= 3; i++) {
            check(i, String.valueOf(i));
        }

        System.out.print("".equals(res) ? -1 : res);
    }

    static void check(int v, String now) {
        if (v == N) { // 목표 값 도달
            if (cnt == K) { // 순번이 K번째인가?
                res = now;
            }

            cnt += 1;
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (v + i > N)
                continue;
            check(v + i, now + "+" + String.valueOf(i));
        }
    }
}
