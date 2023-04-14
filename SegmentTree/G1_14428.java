package SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G1_14428 {
    static int N, M;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        Segment seg = new Segment(nums, N);
        seg.init(1, 1, N);

        M = Integer.parseInt(br.readLine());

        int a, b, c;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                // update
                seg.update(1, 1, N, b, c);
            } else {
                // 출력
                sb.append(seg.getValue(1, 1, N, b, c) + "\n");
            }
        }

        System.out.print(sb.toString());

    }

    static class Segment {
        int[] tree;
        int[] arr;

        Segment(int[] arr, int n) {
            int h = (int) Math.ceil(Math.log(n) / Math.log(2));
            int size = (int) Math.pow(2, h + 1);

            tree = new int[size];
            this.arr = arr;
        }

        void init(int node, int start, int end) {
            if (start == end) {
                tree[node] = start;
                return;
            }

            int mid = (start + end) / 2;
            init(node * 2, start, mid);
            init(node * 2 + 1, mid + 1, end);

            tree[node] = arr[tree[node * 2]] <= arr[tree[node * 2 + 1]] ? tree[node * 2] : tree[node * 2 + 1];

        }

        void update(int node, int start, int end, int idx, int v) {
            if (idx < start || idx > end)
                return;

            if (start == end) {
                tree[node] = idx;
                arr[idx] = v;
                return;
            }

            int mid = (start + end) / 2;

            update(node * 2, start, mid, idx, v);
            update(node * 2 + 1, mid + 1, end, idx, v);

            tree[node] = arr[tree[node * 2]] <= arr[tree[node * 2 + 1]] ? tree[node * 2] : tree[node * 2 + 1];
        }

        int getValue(int node, int start, int end, int qs, int qe) {
            if (qs > end || qe < start)
                return -1;

            if (qs <= start && qe >= end)
                return tree[node];

            int mid = (start + end) / 2;
            int t1 = getValue(node * 2, start, mid, qs, qe);
            int t2 = getValue(node * 2 + 1, mid + 1, end, qs, qe);

            if (t1 == -1)
                return t2;
            else if (t2 == -1)
                return t1;
            else {
                if (arr[t1] <= arr[t2])
                    return t1;
                else {
                    return t2;
                }
            }
        }
    }
}
