package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G5_15686 {
    static int N, M, res;
    static ArrayList<int[]> shop, home;
    static int[] select;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        shop = new ArrayList<>();
        home = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) home.add(new int[] {i, j});
                else if (tmp == 2) shop.add(new int[] {i, j});
            }
        }

        res = Integer.MAX_VALUE;
        cb(0, 0, new int[M]);
        System.out.print(res);
    }

    static void check(int[] arr) {
        int v = 0;

        int x, y;
        for (int[] h : home) {
            x = h[0];
            y = h[1];
            int tmp = 100001;
            for (int i : arr) {
                tmp = Math.min(tmp, Math.abs(x - shop.get(i)[0]) + Math.abs(y - shop.get(i)[1]));
            }

            v += tmp;
        }

        res = Math.min(res, v);
    }

    static void cb(int cnt, int start, int[] arr) {
        if (cnt == M) {
            check(arr);
            return;
        }

        for (int i = start; i < shop.size(); i++) {
            arr[cnt] = i;
            cb(cnt + 1, i + 1, arr);
        }
    }
}
