package SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G1_11505 {
    static int N, M, K;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = new int[N+1];
        for (int i = 1; i < N+1; i++) nums[i] = Integer.parseInt(br.readLine());

        Segment seg = new Segment(nums, N);
        seg.init(1, 1, N);

        int a, b, c;
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                // update
                // seg.updateArr(b, c);
                seg.update(1, 1, N, b, c);
            } else {
                sb.append(seg.getValue(b, c) + "\n");
            }
        }

        System.out.print(sb.toString());
    }

    static class Segment {
        long[] tree;
        int[] arr;

        Segment(int[] arr, int n) {
            int h = (int) Math.ceil(Math.log(n) / Math.log(2));
            int size = (int) Math.pow(2, h + 1);

            tree = new long[size];
            this.arr = arr;
        }

        void init(int node, int start, int end) {
            if(start == end) {
                tree[node] = arr[start];
                return;
            }

            init(node * 2 , start, (start + end) / 2);
            init(node * 2 + 1, (start + end) / 2 + 1, end);

            tree[node] = (tree[node * 2] * tree[node * 2 + 1]) % 1000000007;
        }

        void update(int node, int start, int end, int idx, int v) {
            if (start == end) {
                this.arr[idx] = v;
                tree[node] = v;
                return;
            }

            int mid = (start + end) / 2;
            if (idx <= mid) update(node * 2, start, mid, idx, v);
            else update(node * 2 + 1, mid + 1, end, idx, v);

            if (arr[idx] == 0) tree[node] = 0; // arr 배열의 구간에 0이 포함되어 있으면 구간 곱은 전부다 0
            else tree[node] = (tree[node * 2] * tree[node * 2 + 1]) % 1000000007;
        }

        // void updateArr(int idx, int val) {
        //     this.arr[idx] = val;
        // }

        long getValue(int s, int e) {
            return getValue(1, arr.length - 1, s, e, 1);
        }

        private long getValue(int start, int end, int qs, int qe, int node) {
            if (qs > end || qe < start) return 1;
            else if (qs <= start && qe >= end) return tree[node];
            else {
                int mid = (start + end) / 2;
                return (getValue(start, mid, qs, qe, node * 2) * 
                       getValue(mid + 1, end, qs, qe, node * 2 + 1)) % 1000000007;
            }
            
        }

        int[] getArr() {
            return this.arr;
        }
    }
}
