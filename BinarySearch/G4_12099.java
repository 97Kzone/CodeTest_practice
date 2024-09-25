package BinarySearch;

import java.util.*;
import java.io.*;

public class G4_12099 {

    static int N, Q;
    static int[][] menus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        menus = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            menus[i][0] = Integer.parseInt(st.nextToken());
            menus[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(menus, Comparator.comparing(o -> o[0]));

        int[] std;
        int u, v, x, y, cnt;
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            std = check(u, v);
            cnt = 0;

            for (int j = std[0]; j < std[1]; j++) {
                if (menus[j][1] >= x && menus[j][1] <= y) {
                    cnt++;
                }
            }

            sb.append(cnt + "\n");
        }

        System.out.print(sb);
    }
    
    static int[] check(int u, int v) {
        int s, e, m;
        int l = 0;
        int r = N;
        
        while (l < r) {
            m = (l + r) / 2;

            if (menus[m][0] < u) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        s = r;
        l = s;
        r = N;

        while (l < r) {
            m = (l + r) / 2;

            if (menus[m][0] <= v) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        
        e = r;

        return new int[] { s, e };

    }
}
