package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class G4_12851 {
    static int N, K;
    static int[] check;
    static int[] res = {100001, 0};
    public static void main(String[] args) throws IOException {
        sol();
    }

    static void sol() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        check = new int[100001];
        check[N] = 1;
        bfs();

        System.out.println(res[0]);
        System.out.println(res[1]);
    }

    static void bfs() {
        Deque<int[]> q = new LinkedList<>();
        q.add(new int[] {N, 0});
        int idx, cnt;
        int[] tmp = new int[2];

        while (!q.isEmpty()) {
            tmp = q.pollFirst();
            idx = tmp[0];
            cnt = tmp[1];
            check[idx] = 1;

            if (idx == K) {
                //신기록인가?
                if (cnt < res[0]) {
                    res[0] = cnt;
                    res[1] = 1;
                } else if (cnt == res[0]) {
                    res[1] += 1;
                }
            } else {
                if (idx >= 1 && check[idx-1] == 0) {
                    q.add(new int[] {idx-1, cnt+1});
                }

                if (idx < 100000 && check[idx+1] == 0) {
                    q.add(new int[] {idx+1, cnt+1});
                }

                if (idx*2 < 100001 && check[idx*2] == 0) {
                    q.add(new int[] {idx*2, cnt+1});
                }
            }
        }
    }
}
