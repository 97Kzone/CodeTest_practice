import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SW_5644_2 {
    static int M, A, res;
    static int[] ma, mb, pa, pb;
    static ArrayList<int[]> BC;
    static int[][] moves = {{0, 0}, {0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());

            ma = new int[M+1];
            mb = new int[M+1];
            pa = new int[] {1, 1};
            pb = new int[] {10, 10};
            BC = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < M+1; i++) ma[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < M+1; i++) mb[i] = Integer.parseInt(st.nextToken());

            int x, y, c, p;
            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());

                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
                p = Integer.parseInt(st.nextToken());

                BC.add(new int[] {x, y, c, p});
            }
            
            res = 0;
            for (int i = 0; i < M+1; i++) {
                pa[0] += moves[ma[i]][0];
                pa[1] += moves[ma[i]][1];
                pb[0] += moves[mb[i]][0];
                pb[1] += moves[mb[i]][1];

                check();
            }

            sb.append("#" + t + " ").append(res + "\n");
        }
        System.out.print(sb.toString());
    }

    static void check() {
        int total = 0; 
        int va, vb, v;
        // A 가 골라
        for (int i = 0; i < A; i++) {
            // B 도 골라
            for (int j = 0; j < A; j++) {
                v = 0;
                va = checkDist(pa, BC.get(i));
                vb = checkDist(pb, BC.get(j));         
            
                if (i == j) v = Math.max(va, vb);
                else v = va + vb;

                total = Math.max(total, v);
            }
        }
        res += total;
    }

    static int checkDist(int[] a1, int[] a2) {
        int tmp = Math.abs(a1[0] - a2[0]) + Math.abs(a1[1] - a2[1]);
        if (tmp > a2[2]) return 0;
        return a2[3];
    }
}
