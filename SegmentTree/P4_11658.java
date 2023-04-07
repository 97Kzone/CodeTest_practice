package SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P4_11658 {
    static int N, M;
    static int[][] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N+1][N+1];
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N+1; j++) nums[i][j] = Integer.parseInt(st.nextToken());
        }

        SegMent seg = new SegMent(nums, N);
        seg.init(1, 1, N);

        int a, b, c, d, e;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            if (a == 1) {
                // 구간 합 출력
                sb.append(seg.getValue(1, 1, N, i, e))
            } else {
                // update
                // arr[b][c] = d 
                seg.update(1, 1, N, b * N + c, d - seg.getArr(b, c));
                seg.updateArr(b, c, d);
            }
        }
        
    }

    // 2차원 배열을 다뤄보자
    static class SegMent {
        int[] tree;
        int[][] arr;
        int n;
        SegMent(int[][] arr, int n) {
            int h = (int) Math.ceil(Math.log(n) / Math.log(2));
            int size = (int) Math.pow(2, h + 1);

            tree = new int[size * size];
            this.arr = arr;
            this.n = n;
        }

        int init(int node, int start, int end) {
            if (start == end) return tree[node] = arr[start / n][start % n];

            int mid = (start + end) / 2;
            return tree[node] = init(node * 2, start, mid) +
                                init(node * 2 + 1, mid + 1, end);
        }

        void update(int node, int start, int end, int idx, int v) {
            if (idx < start || idx > end) return;

            tree[node] += v;

            int mid = (start + end) / 2;
            update(node * 2, start, mid, idx, v);
            update(node * 2 + 1, mid + 1, end, idx, v);

            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }

        int getValue(int node, int start, int end, int qs, int qe) {
            if (qs > end || qe < start) return 0;
            if (qs <= start && qe >= end) return tree[node];

            int mid = (start + end) / 2;
            return getValue(node * 2, start, mid, qs, qe) +
                   getValue(node * 2 + 1, mid + 1, end, qs, qe);
        }

        void updateArr(int x, int y, int v) {
            this.arr[x][y] = v;
        } 

        int getArr(int x, int y) {
            return arr[x][y];
        }
    }
}
