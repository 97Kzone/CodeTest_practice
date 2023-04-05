package SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G1_2268 {
    static int N, M;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N+1];
        // for (int i = 1; i < N+1; i++) nums[i] = i;
        
        SegMent seg = new SegMent(nums, N);
        seg.init(1, 1, N);

        int a, b, c; 
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (a == 0) {
                // 누적합 출력
                if (b < c) sb.append(seg.getValue(1, 1, N, b, c) + "\n");
                else sb.append(seg.getValue(1, 1, N, c, b) + "\n");
            } else {
                // b번째 값 c 로 변경
                seg.update(1, 1, N, b, c - seg.getArr(b));
                seg.updateArr(b, c);
            }
        }
        System.out.print(sb.toString());
    }

    static class SegMent {
        long[] tree;
        int[] arr;

        SegMent (int[] arr, int n) {
            int h = (int) Math.ceil(Math.log(n) / Math.log(2));
            int size = (int) Math.pow(2, h + 1);

            tree = new long[size];
            this.arr = arr;
        }   

        long init(int node, int start, int end) {
            if (start == end) return tree[node] = arr[start];
            
            int mid = (start + end) / 2;
            return tree[node] = init(node * 2, start, mid) +
                                init(node * 2 + 1, mid + 1, end);
        }

        void update(int node, int start, int end, int idx, int diff) {
            if (idx < start || idx > end) return;

            tree[node] += diff;

            int mid = (start + end) / 2;
            if (start != end) {
                update(node * 2, start , mid, idx, diff);
                update(node * 2 + 1, mid + 1, end, idx, diff);
            } 
            
        }

        long getValue(int node, int start, int end, int qs, int qe) {
            if (qe < start || qs > end) return 0;
            
            if (qs <= start && qe >= end) return tree[node];

            int mid = (start + end) / 2;
            return getValue(node * 2, start, mid, qs, qe) +
                   getValue(node * 2 + 1, mid + 1, end, qs, qe);
        }

        void updateArr(int idx, int v) {
            this.arr[idx] = v;
        }

        int getArr(int idx) {
            return this.arr[idx];
        }
    }
}
