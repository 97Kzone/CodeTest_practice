package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class S5_32930 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int x, y;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            list.add(new int[] {x, y});
        }

        int res = 0;
        x = 0;
        y = 0;
        for (int i = 0; i < M; i++) {
            int tx = x;
            int ty = y;
            list.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    int v1 = (tx - o1[0]) * (tx - o1[0]) + (ty - o1[1]) * (ty - o1[1]);
                    int v2 = (tx - o2[0]) * (tx - o2[0]) + (ty - o2[1]) * (ty - o2[1]);
                    return Integer.compare(v2, v1);
                }
            });

            int[] std = list.remove(0);
            int nx = std[0];
            int ny = std[1];

            res += (nx - x) * (nx - x) + (ny - y) * (ny - y);
            x = nx;
            y = ny;

            st = new StringTokenizer(br.readLine());
            int tmp1 = Integer.parseInt(st.nextToken());
            int tmp2 = Integer.parseInt(st.nextToken());
            list.add(new int[] {tmp1, tmp2});
        }

        System.out.print(res);
    }
}
