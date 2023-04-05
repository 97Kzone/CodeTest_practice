package SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G1_1275 {
    static int N, Q;
    static long[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        nums = new long[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) nums[i] = Integer.parseInt(st.nextToken());

        SegMent seg = new SegMent(nums, N);
        seg.init(1, 1, N);

        int a, b, c, d;
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            if (a < b) sb.append(seg.getValue(a, b) + "\n");
            else sb.append(seg.getValue(b, a) + "\n");

            seg.update(c, d);
            seg.updateArr(c, d);
        }

        System.out.print(sb.toString());
    }

    static class SegMent {
        long[] tree;
        long[] arr;

        SegMent (long[] arr, int n) {
            int h = (int) Math.ceil(Math.log(n) / Math.log(2));
            int size = (int) Math.pow(2, h + 1);

            tree = new long[size];
            this.arr = arr;
        }

        void init(int node, int start, int end) {
            if (start == end) {
                tree[node] = this.arr[start];
                return;
            }

            int mid = (start + end) / 2;
            
            init(node * 2, start, mid);
            init(node * 2 + 1, mid + 1, end);
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }

        public void update(int idx, int v) {
            long diff = v - this.arr[idx];
            update(1, 1, arr.length - 1, idx, diff);
        }

        private void update(int node, int start, int end, int idx, long diff) {
            if (idx < start || idx > end) return;
            
            tree[node] += diff;
            
            if (start != end) {
                int mid = (start + end) / 2;
                update(node * 2, start, mid, idx, diff);
                update(node * 2 + 1, mid + 1, end, idx, diff);
            }
        }  

        long getValue(int s, int e) {
            return getValue(1, 1, arr.length - 1, s, e) ;
        }

        private long getValue(int node, int start, int end, int qs, int qe) {
            if (qs > end || qe < start ) return 0;
            if (qs <= start && qe >= end) return tree[node];

            int mid = (start + end) / 2;
            return getValue(node * 2, start, mid, qs, qe) + 
                   getValue(node * 2 + 1, mid + 1, end, qs, qe);
        }

        void updateArr(int idx, int v) {
            this.arr[idx] = v;
        }
    }
}
