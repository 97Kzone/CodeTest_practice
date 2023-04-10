package SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P4_11658 {
    static int N, M;
    static int[][] nums, ftree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N+1][N+1];
        ftree = new int[N+1][N+1];

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N+1; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
                update(i, j, nums[i][j]);
            }
        }

        int a, b, c, d, e;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            if (a == 1) {
                // 구간 합 출력
                e = Integer.parseInt(st.nextToken());
                sb.append(sum(d, e) - sum(d, c-1) - sum(b-1, e) + sum(b-1, c-1) + "\n");
            } else {
                // update
                // arr[b][c] = d 
                update(b, c, d - nums[b][c]);
                nums[b][c] = d;
            }
        }
        System.out.print(sb.toString());
    }

    static void update(int x, int y, int val) {
        int ty = y;

        while (x < N + 1) {
            while (ty < N + 1) {
                ftree[x][ty] += val;
                ty += (ty & -ty); 
            }

            x += (x & -x);
            ty = y;
        }
    }

    static long sum(int s, int e) {
        long res = 0;
        int te = e;

        while (s > 0) {

            while (te > 0) {
                res += ftree[s][te];
                te -= (te & -te);
            }

            s -= (s & -s);
            te = e;
        }

        return res;
    }
}
