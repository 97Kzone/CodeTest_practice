package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G3_9466 {
    static int N, res;
    static int[] nums;
    static boolean[] visit, cycle;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            nums = new int[N+1];
            visit = new boolean[N+1]; // 방문 했는가?
            cycle = new boolean[N+1]; // 팀 편성 됐는가?
            res = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N+1; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i < N+1; i++) {
                if (!cycle[i]) {
                    check(i);
                }
            }

            System.out.println(N - res);
        }
    }
    static void check(int n) {
        if (visit[n]) {
            cycle[n] = true;
            res++;
        } else {
            visit[n] = true;
        }

        if (!cycle[nums[n]]) check(nums[n]);
    
        visit[n] = false;
        cycle[n] = true;
    }
}
