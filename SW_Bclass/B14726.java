package SW_Bclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14726 {

    static int N, Q;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            Q = Integer.parseInt(st.nextToken());

            nums = new int[N];
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++)
                nums[i] = Integer.parseInt(st.nextToken());

            // 세그트리 생성
            SegMent seg = new SegMent(nums, N);
            sb.append("#" + t + " ");

            int a, b, c;
            for (int i = 0; i < Q; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());

                if (a == 0)
                    seg.update(1, 0, N - 1, b, c);
                else {
                    int max = seg.max(1, 0, N - 1, b, c - 1);
                    int min = seg.min(1, 0, N - 1, b, c - 1);
                    sb.append(max - min).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
        
    static class SegMent {
        int[] minTree, maxTree, arr;

        public SegMent (int[] arr, int n) {
            minTree = new int[4 * n];
            maxTree = new int[4 * n];
            this.arr = arr;

            init(1, 0, N-1);
        }

        void init(int node, int l, int r) {
            if (l == r) {
                maxTree[node] = arr[l];
                minTree[node] = arr[l];
                return;
            }

            int m = (l + r) / 2;

            init(node * 2, l, m);
            init(node * 2 + 1, m + 1, r);

            maxTree[node] = Math.max(maxTree[node * 2], maxTree[node * 2 + 1]);
            minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]);
        }

        void update(int node, int l, int r, int idx, int v) {
            if (idx < l || r < idx)
                return;

            if (l == r) {
                maxTree[node] = v;
                minTree[node] = v;
                return;
            }
            int m = (l + r) / 2;
            update(node * 2, l, m, idx, v);
            update(node * 2 + 1, m + 1, r, idx, v);

            maxTree[node] = Math.max(maxTree[node * 2], maxTree[node * 2 + 1]);
            minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]);
        }
        
        int max(int node, int l, int r, int ql, int qr) {
            if (qr < l || r < ql)
                return 0;

            if (ql <= l && r <= qr) {
                return maxTree[node];
            }

            int m = (l + r) / 2;
            int lm = max(node * 2, l, m, ql, qr);
            int rm = max(node * 2 + 1, m + 1, r, ql, qr);

            return Math.max(lm, rm);
        }
        
        int min(int node, int l, int r, int ql, int qr) {
            if (qr < l || r < ql)
                return Integer.MAX_VALUE;
            
            if (ql <= l && r <= qr) {
                return minTree[node];
            }

            int m = (l + r) / 2;
            int lm = min(node * 2, l, m, ql, qr);
            int rm = min(node * 2 + 1, m + 1, r, ql, qr);

            return Math.min(lm, rm);
        }
    }
}
