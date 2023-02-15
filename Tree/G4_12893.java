package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_12893 {
    static int N, M, res;
    static int[] p, check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        p = new int[N+1];
        check = new int[N+1];

        for (int i = 1; i < N+1; i++) {
            p[i] = i;
        }

        res = 1;
        int a, b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if (find(a) == find(b)) res = 0; // 입력은 M번까지 받는다..

            if (check[a] != 0) union(check[a], b);
            else check[a] = b;

            if (check[b] != 0) union(check[b], a);
            else check[b] = a;
        }
        System.out.print(res);
    }

    static int find(int x) {
        if (x == p[x]) return x;
        else return p[x] = find(p[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return; // 부모가 같으면 => 이미 포함관계
        else {
            if (a < b) p[b] = a;
            else p[a] = b;
        }
    }
}
