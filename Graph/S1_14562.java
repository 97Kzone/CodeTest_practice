package Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_14562 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        int a, b, v;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            v = check(a, b);
            bw.write(v + "\n");
        }

        bw.flush();
        bw.close();
    }

    static int check(int A, int B) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {A, B, 0});

        int[] now;
        int a, b;
        while(!q.isEmpty()) {
            now = q.poll();

            a = now[0];
            b = now[1];
            if (a == b) return now[2];

            if (!isPossible(a, b)) continue;
            q.offer(new int[] {a * 2, b + 3, now[2] + 1});
            q.offer(new int[] {a + 1, b, now[2] + 1});
        }

        return -1;
    }

    static boolean isPossible(int x, int y) {
        return (0 <= x && x < 200) && (0 <= y && y < 200);
    }
}
