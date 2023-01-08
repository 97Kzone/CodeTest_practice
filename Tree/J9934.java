package Tree;

import java.util.*;

public class J9934 {
    static int K;
    static List<Integer>[] res;
    static int[] nums;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        K = sc.nextInt();
        int v = (int) Math.pow(2, K);
        nums = new int[v-1];
        res = new ArrayList[K];

        for(int i=0; i<v-1; i++) {
            nums[i] = sc.nextInt();
        }

        for (int i=0; i<K; i++) {
            res[i] = new ArrayList<>();
        }

        make(0, v-1, 0);

        for (int i=0; i<K; i++) {
            for (int n : res[i]) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    public static void make(int s, int e, int d) {
        if (d == K) return;
        int m = (s+e) / 2;

        res[d].add(nums[m]);
        make(s, m-1, d+1);
        make(m+1, e, d+1);
    }
}
