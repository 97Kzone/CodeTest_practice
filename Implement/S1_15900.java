package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S1_15900 {

    static int N, res;
    static List<Integer>[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        tree = new List[N+1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        int a, b;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }

        check(0, 1, 0);
        System.out.println(res % 2 == 1 ? "Yes" : "No");
    }

    static void check(int depth, int now, int parent) {
        boolean flag = false;

        for (int nxt : tree[now]) {
            if (parent != nxt) {
                flag = true;
                check(depth + 1, nxt, now);
            }
        }

        if (!flag) res += depth;
    }
}
