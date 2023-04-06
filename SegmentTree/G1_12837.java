package SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 세그먼트 트리 Day 3
public class G1_12837 {
    static int N, Q;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        nums = new int[N+1];
        SegMent seg = new SegMent(nums, N);
        seg.init(1, 1, N);

        int a, b, c;
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                // update
                seg.update(1, 1, N, b, c);
                seg.updateArr(b, c);
            } else {
                // 출력
                sb.append(seg.getValue(1, 1, N, b, c) + "\n");
            }
        }
        System.out.print(sb.toString());
    }

    static class SegMent {
        long[] tree;
        int[] arr;

        SegMent(int[] arr, int n) {
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
        }

        void update(int node, int start, int end, int idx, int v) {
            if (idx < start || idx > end) return;

            tree[node] += v;
            
            if (start != end) {
                int mid = (start + end) / 2;
                update(node * 2, start, mid, idx, v);
                update(node * 2 + 1, mid + 1, end, idx, v);
            } 
        }

        long getValue(int node, int start, int end, int qs, int qe) {
            if (qs > end || qe < start) return 0; 

            if (qs <= start && qe >= end) return tree[node];

            int mid = (start + end) / 2;
            return getValue(node * 2, start, mid, qs, qe) +
                   getValue(node * 2 + 1, mid + 1, end, qs, qe);
        }

        void updateArr(int idx, int value) {
            this.arr[idx] += value;
        }

        int getArr(int idx) {
            return this.arr[idx];
        }
    }

}
