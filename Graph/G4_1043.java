package Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class G4_1043 {
    static int N, M;
    static int[] parent;
    static boolean[] check;
    static int res = 0;
    public static void main(String[] args) {
       sol();
    }
    
    static void sol() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        parent = new int[N+1];
        check = new boolean[N+1];
        for (int i = 1; i < N+1; i++) {
            parent[i] = i;
        }

        int v = sc.nextInt();
        int idx;     
        for (int i = 0; i < v; i++) {
            idx = sc.nextInt();
            check[idx] = true;
        }

        ArrayList<Integer>[] pp = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            pp[i] = new ArrayList<>();
        }

        int std = 0;
        int tmp = 0;
        for (int i = 0; i < M; i++) {
            v = sc.nextInt();
            std = sc.nextInt();
            pp[i].add(std);
            for (int j = 1; j < v; j++) {
                tmp = sc.nextInt();
                pp[i].add(tmp);
                union(std, tmp);
                std = tmp;
            }
        }

        for (int i = 1; i < check.length; i++) {
            if (check[i]) {
                check[find(i)] = true;
            }
        }

        int p;
        for (int i = 0; i < M; i++) {
            if (pp[i].size() > 0) {
                p = find(pp[i].get(0));
                if (!check[p]) res += 1;
            }
        }

        System.out.println(res);
    }

    static int find(int x) {
        if (parent[x] == x) {
            return parent[x] = x;
        } else {
            return find(parent[x]);
        }
    }

    static boolean union(int x, int y) {
        int v1 = find(x);
        int v2 = find(y);

        if (v1 != v2) {
            if (v1 > v2) {
                parent[v1] = v2;
            } else {
                parent[v2] = v1;
            }
            return true;
        }
        return false;
    }
}
