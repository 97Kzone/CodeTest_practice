package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class G4_23835 {

    static int N;
    static List<Integer>[] graph;
    static int[] move, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        move = new int[1001];
        cnt = new int[1001];
        graph = new ArrayList[1001];
        for (int i = 1; i < 1001; i++) {
            graph[i] = new ArrayList<>();
        }

        int s, e;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            graph[s].add(e);
            graph[e].add(s);
        }

        int Q = Integer.parseInt(br.readLine());

        int a, b, c;
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());

            if (a == 1) {
                b = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());

                check(b, c, 0, 0);
            } else {
                b = Integer.parseInt(st.nextToken());
                sb.append(cnt[b] + "\n");
            }
        }
        System.out.print(sb);
    }

    static boolean check(int now, int end, int pre, int v) {
        move[v] = now;
        if (now == end) {
            for (int i = 0; i <= v; i++) {
                cnt[move[i]] += i;
            }
            return true;
        }

        boolean flag = false;
        for (int nxt : graph[now]) {
            if (nxt == pre)
                continue;
            
            if (check(nxt, end, now, v + 1)) {
                flag = true;
            }
        }
        return flag;
    }

}
