package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_24229 {

    static int N;
    static List<int[]> nums, board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new ArrayList<>();

        int l, r;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());

            nums.add(new int[] { l, r });
        }

        nums.sort((o1, o2) -> (o1[0] - o2[0]));

        board = new ArrayList<>();
        board.add(nums.get(0));

        int[] now, std;
        int idx = board.size();
        for (int i = 1; i < N; i++) {
            now = board.get(idx - 1);
            std = nums.get(i);
            if (now[1] >= std[0]) {
                board.remove(idx - 1);
                board.add(new int[] { now[0], Math.max(now[1], std[1]) });
            } else {
                board.add(std);
                idx++;
            }
        }

        int res = check();
        System.out.print(res);
    }
    
    static int check() {
        boolean[] visit = new boolean[N];
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(0);

        int std = 0;
        int now, nxt;
        int[] v, nv;
        while (!dq.isEmpty()) {
            now = dq.pollFirst();
            v = board.get(now);

            if (visit[now])
                continue;

            visit[now] = true;
            nxt = v[1] - v[0];
            std = Math.max(std, v[1]);

            for (int i = now + 1; i < board.size(); i++) {
                nv = board.get(i);

                if (nv[0] <= v[1] + nxt) {
                    dq.offer(i);
                } else
                    break;
            }
        }
        
        return std;
    }
}
