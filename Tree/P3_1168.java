package Tree;

import java.util.Scanner;

public class P3_1168 {
    static int N, K;
    static int[] tree;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        N = sc.nextInt();
        K = sc.nextInt();

        tree = new int[4*N];
        makeTree(1, 1, N);
        
        int std = K;
        sb.append("<");

        for (int i = 1; i < N; i++) {
            sb.append(check(1, 1, N, std) + ", ");
            std += K-1;
            std = (std - 1) % tree[1] + 1;
        }
        sb.append(check(1, 1, N, std) + ">");
        System.out.print(sb.toString());
    }

    static int check(int idx, int s, int e, int k) {
        tree[idx]--;

        if (s == e) return s;

        int mid = (s + e) / 2;
        if (tree[idx * 2] >= k) return check(idx * 2, s, mid, k);

        return check((idx * 2) + 1, mid + 1, e, k - tree[idx * 2]);
        
    }

    static void makeTree(int idx, int s, int e) {
        if (s == e) {
            tree[idx] = 1;
            return;
        }

        int mid = (s + e) / 2;
        makeTree(idx * 2, s, mid);
        makeTree((idx * 2) + 1, mid + 1, e);
        tree[idx] = tree[idx * 2] + tree[(idx * 2) + 1];
    }
}
