package SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 세그먼트 트리 연습 Day 1
public class G1_2042 {
    static int N, M, K;
    static long nums[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = new long[N + 1];
        for (int i = 1; i < N+1; i++) nums[i] = Long.parseLong(br.readLine());

        SegTree seg = new SegTree(nums, N);
        seg.init(1, 1, N);

        int a, b;
        long c;
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Long.parseLong(st.nextToken());

            if (a == 1) {
                // update
                seg.update(1, 1, N, b, c - seg.getArr()[b]);
                seg.updateArr(b, c);
            } else {
                // 누적합 출력
                sb.append(seg.sum(1, 1, N, b, (int) c) + "\n");
            }
        }

        System.out.print(sb.toString());
    }
}

// 세그먼트 트리
class SegTree {
    long tree[];
    long arr[];
    int size;

    SegTree(long[] arr, int n) {
        // 트리 높이, 크기 구하기
        int h = (int) Math.ceil(Math.log(n)/Math.log(2));
        this.size = (int) Math.pow(2, h + 1);

        tree = new long[size];
        this.arr = arr;
    }

    long init(int node, int start, int end) {
        if (start == end)  return tree[node] = this.arr[start];
        
        return tree[node] = init(node*2, start, (start + end) / 2)
                            + init(node*2 + 1, (start + end) / 2 + 1, end);
    } 

    // node : 현재 노드 idx
    // idx : 변경할 데이터의 idx
    void update(int node, int start, int end, int idx, long diff) {
        if (idx < start || idx > end) return;

        tree[node] += diff;

        if (start != end) {
            update(node*2, start, (start + end) / 2, idx, diff);
            update(node*2 + 1, (start + end) / 2 + 1, end, idx, diff);
        }
    }

    long sum(int node, int start, int end, int l, int r) {
        if (l > end || r < start ) return 0;

        if (l <= start && end <= r) return tree[node];

        return sum(node * 2, start, (start + end) / 2, l, r) +
               sum(node * 2 + 1, (start + end) / 2 + 1, end, l, r);
    }

    long[] getArr() {
        return this.arr;
    }

    void updateArr(int idx, long value) {
        this.arr[idx] = value;
    }
}
