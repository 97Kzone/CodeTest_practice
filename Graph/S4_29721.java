package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class S4_29721 {

    static int N, K;
    static List<long[]> board;
    static HashSet<Long> set1, set2;
    static int[][] moves = { { -2, 0 }, { 2, 0 }, { 0, -2 }, { 0, 2 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new ArrayList<>();
        set1 = new HashSet<>();
        set2 = new HashSet<>();

        long x, y;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            board.add(new long[] { x, y });
            set1.add(x * N + y);
        }

        for (long[] xy : board) {
            check(xy[0], xy[1]);
        }

        System.out.print(set2.size());
    }
    
    static void check(long x, long y) {
        long nx, ny;
        for (int[] move : moves) {
            nx = x + move[0];
            ny = y + move[1];

            if (!isPossible(nx, ny) || set1.contains(nx * N + ny))
                continue;
            
            set2.add(nx * N + ny);
        }
    }

    static boolean isPossible(long x, long y) {
        return (0 < x && x <= N) && (0 < y && y <= N);
    }
}
