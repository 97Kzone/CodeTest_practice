package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_1722 {

    static int N;
    static int[] nums;
    static long[] std;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        init();

        int cmd;
        st = new StringTokenizer(br.readLine());
        cmd = Integer.parseInt(st.nextToken());

        if (cmd == 1) {
            check1(Long.parseLong(st.nextToken()));
        } else {
            for (int j = 0; j < N; j++) {
                nums[j] = Integer.parseInt(st.nextToken());
            }
            check2();
        }

        System.out.print(sb.toString());
    }

    static void check1(long K) {
        boolean[] visit = new boolean[N+1];
        int[] res = new int[N];

        long a, b;
        int cnt;
        for (int i = 0; i < N; i++) {
            a = std[N - 1 - i];
            b = (K - 1) / a;

            cnt = -1;
            for (int j = 1; j <= N; j++) {
                if(visit[j]) continue;

                cnt++;
                if(cnt == b) {
                    visit[j] = true;
                    res[i] = j;
                    break;
                }
            }
            K = (K - 1) % a + 1;    
        }

        for (int i = 0; i < N; i++) {
            sb.append(res[i] + " ");
        }
    }

    static void check2() {
        boolean[] visit = new boolean[N+1];
        long res = 0;

        int idx, cnt;
        for (int i = 0; i < N; i++) {
            idx = nums[i];

            cnt = 0;
            for (int j = 1; j < idx; j++) {
                if (!visit[j]) cnt++;
            }
            res += (cnt * std[N - 1 - i]);
            visit[idx] = true;
        }

        sb.append(res + 1);
    }

    static void init() {
        std = new long[21];
        std[0] = 1;

        for (int i = 1; i <= N; i++) {
            std[i] =std[i-1] * i;
        }
    }
}
