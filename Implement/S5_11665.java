package Implement;

import java.io.*;
import java.util.*;

public class S5_11665 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<int[]> xlist = new ArrayList<>();
        List<int[]> ylist = new ArrayList<>();
        List<int[]> zlist = new ArrayList<>();

        int x1, y1, z1, x2, y2, z2;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            z1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            z2 = Integer.parseInt(st.nextToken());

            xlist.add(new int[]{x1, x2});
            ylist.add(new int[]{y1, y2});
            zlist.add(new int[]{z1, z2});
        }

        int[] x = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
        int[] y = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
        int[] z = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};

        for (int i = 0; i < N; i++) {
            x = merge(x, xlist.get(i));
            y = merge(y, ylist.get(i));
            z = merge(z, zlist.get(i));
        }

        int res = Math.max(0, x[1] - x[0]) * Math.max(0, y[1] - y[0]) * Math.max(0, z[1] - z[0]);
        System.out.print(res);
    }

    static int[] merge(int[] A, int[] B) { 
        return new int[]{Math.max(A[0], B[0]), Math.min(A[1], B[1])};
    }
}

