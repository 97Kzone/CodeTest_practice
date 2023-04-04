package SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G1_2357 {
    static int N, M;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N + 1];
        for (int i = 1; i < N + 1; i++) nums[i] = Integer.parseInt(br.readLine());

        SegTree2 seg = new SegTree2(nums, N);
        seg.init(1, 1, N);

        int a, b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            sb.append(seg.getMin(a, b) + " " + seg.getMax(a, b) + "\n");
        }   
        System.out.print(sb.toString());
    }
}

class SegTree2 {
    int[] minTree;
    int[] maxTree;
    int[] arr;

    SegTree2(int[] arr, int n) {
        int h = (int) Math.ceil(Math.log(n) / Math.log(2));
        int size = (int) Math.pow(2, h+1);

        minTree = new int[size];
        maxTree = new int[size];
        this.arr = arr;
    }

    void init(int node, int start, int end) {
        if (start == end) {
            minTree[node] = arr[start];
            maxTree[node] = arr[start];
            return;
        }

        init(node * 2, start, (start + end) / 2);
        init(node * 2 + 1, (start + end) / 2 + 1, end);

        minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]);
        maxTree[node] = Math.max(maxTree[node * 2], maxTree[node * 2 + 1]);
    }

    public int getMax(int s, int e) {
        return getMax(1, arr.length - 1, s, e, 1);
    }
    
    private int getMax(int start, int end, int qs, int qe, int node) {
        if (start > qe || end < qs) return Integer.MIN_VALUE;
        else if (qs <= start && qe >= end) return maxTree[node];
        else {
            int mid = (start + end) / 2;
            return Math.max(getMax(start, mid, qs, qe, node * 2), getMax(mid + 1, end , qs, qe, node * 2 + 1));  
        }
    }

    public int getMin(int s, int e) {
        return getMin(1, arr.length - 1, s, e, 1);
    }

    private int getMin(int start, int end, int qs, int qe, int node) {
        if (start > qe || end < qs) return Integer.MAX_VALUE;
        else if (qs <= start && qe >= end) return minTree[node];
        else {
            int mid = (start + end) / 2;
            return Math.min(getMin(start, mid, qs, qe, node * 2), getMin(mid + 1, end , qs, qe, node * 2 + 1));  
        }
    }

    // 하위 로직은 쓰지 않지만 변경이 생기면 반영
    public void update(int idx, int v) {
        update(1, arr.length - 1, idx, v, 1);
    }

    private void update(int start, int end, int idx, int v, int node) {
        if (idx < start || idx > end) return;

        arr[idx] = v;
        maxTree[node] = v;
        minTree[node] = v; 

        if (start != end) {
            update(start, (start + end) / 2, idx, v, node * 2);
            update((start + end) / 2 + 1, end, idx, v, node * 2 + 1);
            maxTree[node] = Math.max(maxTree[node * 2], maxTree[node * 2 + 1]);
            minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]);
        }
    }
}
