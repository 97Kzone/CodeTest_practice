package SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G1_10868 {
    static int N, M;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N+1];
        for (int i = 1; i < N + 1; i++) nums[i] = Integer.parseInt(br.readLine());

        SegTree seg = new SegTree(nums, N);
        seg.init(1, 1, N);

        int a, b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            sb.append(seg.getMin(a, b) + "\n");
        }

        System.out.print(sb.toString());
    }

    static class SegTree {
        int[] minTree; // 최소값 관리
        int[] arr; // 원본

        // Constructor
        SegTree(int[] arr, int n) {
            int h = (int) Math.ceil(Math.log(n) / Math.log(2));
            int size = (int) Math.pow(2, h+1);
            
            minTree = new int[size * 2];
            this.arr = arr;
        }
    
        void init(int node, int start, int end) {
            if (start == end) {
                minTree[node] = arr[start];
                return;
            }

            init(node * 2, start, (start + end) / 2);
            init(node * 2 + 1, (start + end) / 2 + 1, end);

            minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]);
        }

        public int getMin(int s, int e) {
            return getMin(1 , arr.length - 1, s, e, 1);
        }

        private int getMin(int start, int end, int qs, int qe, int node) {
            if (start > qe || end < qs) return Integer.MAX_VALUE;
            else if (qs <= start && qe >= end) return minTree[node];
            else {
                int mid = (start + end) / 2;
                return Math.min(getMin(start, mid, qs, qe, node * 2), 
                                getMin(mid + 1, end, qs, qe, node * 2 + 1));
            }
        }
    }
}


