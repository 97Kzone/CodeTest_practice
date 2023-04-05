package SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5_1725 {
    static int N;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(br.readLine());
        SegMent seg = new SegMent(nums, N);
        seg.init(1, 0, N-1);

        System.out.print(seg.getMaxArea(0, N-1));
    }

    static class SegMent {
        int[] tree;
        int[] arr;
        int n;

        SegMent(int[] arr, int n) {
            int h = (int) Math.ceil(Math.log(n) / Math.log(2));
            int size = (int) Math.pow(2, h + 1);

            tree = new int[size];
            this.arr = arr;
            this.n = n;
        }
        
        int init(int node, int start, int end) {
            if (start == end) return tree[node] = arr[start];
        
            int mid = (start + end) / 2;
            int left = init(node * 2, start, mid);
            int right = init(node * 2 + 1, mid + 1, end);

            return tree[node] = arr[left] < arr[right] ? left : right;
        }

        int getValue(int node, int start, int end, int left, int right) {
            if (right < start || left > end) return - 1;

            if (left <= start && right >= end) return tree[node];

            int mid = (start + end) / 2;
            int lIdx = getValue(node * 2, start, mid, left, right);
            int rIdx =  getValue(node * 2 + 1, mid + 1, end, left, right);

            if (lIdx == -1) return rIdx;
            else if (rIdx == -1) return lIdx;
            else return arr[lIdx] < arr[rIdx] ? lIdx : rIdx;
        }

        int getMaxArea(int left, int right) {
            if (left > right) return 0;

            int idx = getValue(1, 0, N-1, left, right);
            
            int leftArea = (left == idx) ? 0 : getMaxArea(left, idx - 1);
            int rightArea = getMaxArea(idx + 1, right);
            int area = arr[idx] * (right - left + 1);
        
            return Math.max(area, Math.max(leftArea, rightArea));
        }
    }
}
