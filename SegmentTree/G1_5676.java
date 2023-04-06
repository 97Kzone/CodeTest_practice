package SegmentTree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G1_5676 {
    static int N, K;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        String s = "";
        while ((s = br.readLine()) != null && !s.isEmpty()) {
            st = new StringTokenizer(s);

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
    
            nums = new int[N + 1];
            st = new StringTokenizer(br.readLine());
    
            for (int i = 1; i < N+1; i++) {
                int v = Integer.parseInt(st.nextToken());
                nums[i] = v == 0 ? 0 : v > 0 ? 1 : -1;
            }

            SegMent seg = new SegMent(nums, N);
            seg.init(1, 1, N);
    
            String comm; // 명령
            int a, b; // i, j
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
    
                comm = st.nextToken();
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                
                if ("C".equals(comm)) {
                    b = b == 0 ? 0 : b > 0 ? 1 : -1;
                    seg.update(1, 1, N, a, b);
                }
                else {
                    long v = seg.getValue(a, b);

                    if (v == 0) sb.append("0");
                    else if (v > 0) sb.append("+");
                    else sb.append("-");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    // 탑 다운
    static class SegMent {
        long[] tree;
        int[] arr;

        SegMent(int[] arr, int n) {
            int h = (int) Math.ceil(Math.log(n) / Math.log(2));
            int size = (int) Math.pow(2, h + 1);

            tree = new long[size];
            this.arr = arr;
        }

        long init(int node, int start, int end) {
            if (start == end) return tree[node] = arr[start];

            int mid = (start + end) / 2;
            return tree[node] = init(node * 2, start, mid) * 
                                init(node * 2 + 1, mid + 1, end);
        }

        // 값 변경
        void update(int node, int start, int end, int idx, int v) {
            if (start == end) {
                this.arr[idx] = v;
                tree[node] = arr[idx];
                return;
            }

            int mid = (start + end) / 2;
            if (idx <= mid) update(node * 2, start, mid, idx, v);
            else update(node * 2 + 1, mid + 1, end, idx, v);

            if (arr[idx] == 0) tree[node] = 0;
            else tree[node] = (tree[node * 2] * tree[node * 2 + 1]);
        }

        long getValue(int s, int e) {
            return getValue(1, 1, arr.length - 1, s, e);
        }

        // 값 조회
        private long getValue(int node, int start, int end, int qs, int qe) {
            if (qs > end || qe < start) return 1;
            else if (qs <= start && qe >= end) return tree[node];
            else {
                int mid = (start + end) / 2;
                return (getValue(node * 2, start, mid, qs, qe) * 
                        getValue(node * 2 + 1, mid + 1, end, qs, qe));
            }
        }
    }
}
