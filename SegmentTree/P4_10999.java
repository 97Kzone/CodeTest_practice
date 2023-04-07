package SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P4_10999 {
    static int N, M, K;
    static long[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = new long[N+1];
        for (int i = 1; i < N+1; i++) nums[i] = Long.parseLong(br.readLine());

        SegMent seg = new SegMent(nums, N);
        seg.init(1, 1, N);

        int a, b, c;
        long d;
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            
            if (a == 2) sb.append(seg.getValue(1, 1, N, b, c) + "\n");
            else {
                d = Long.parseLong(st.nextToken());
                seg.update(1, 1, N, b, c, d);
            }
        }

        System.out.print(sb.toString());
    }

    static class SegMent {
        long[] tree;
        long[] arr;
        long[] lazy;

        SegMent(long[] arr, int n) {
            int h = (int) Math.ceil(Math.log(n) / Math.log(2));
            int size = (int) Math.pow(2, h + 1);

            tree = new long[size];
            lazy = new long[size];
            this.arr = arr;
        }
    
        long init(int node, int start, int end) {
            if (start == end) return tree[node] = arr[start];

            int mid = (start + end) / 2;
            return tree[node] = init(node * 2, start, mid) +
                                init(node * 2 + 1, mid + 1, end);
        }

        void propagate(int node, int start, int end) {
            if (lazy[node] == 0) return;
            
            tree[node] += (end - start + 1) * lazy[node];

            if (start != end) {
                lazy[node * 2]  += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            lazy[node] = 0;
        }

        void update(int node, int start, int end, int l, int r, long v) {
            propagate(node, start, end);

            if (r < start || l > end) return;

            if (l <= start && r >= end) {
                tree[node] += (end - start + 1) * v;

                if (start != end) {
                    lazy[node * 2] += v;
                    lazy[node * 2 + 1] += v;
                }

                return;
            }

            int mid = (start + end) / 2;
            update(node * 2, start, mid, l, r, v);
            update(node * 2 + 1, mid + 1, end, l, r, v);
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }

        long getValue(int node, int start, int end, int qs, int qe) {
            propagate(node, start, end);

            if (qs > end || qe < start) return 0;
            if (qs <= start && qe >= end) return tree[node];

            int mid = (start + end) / 2;
            return getValue(node * 2, start, mid, qs, qe) +
                   getValue(node * 2 + 1, mid + 1, end, qs, qe);
        }
    }
}
