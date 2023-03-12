package AI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class A {
    static int N, S;
    static int[] floor;
    static boolean[] visit;
    static String res;

    static class Node {
        int s, f; // 속도 층수
        String cmd;

        Node(int f, int s, String cmd) {
            this.f = f;
            this.s = s;
            this.cmd = cmd;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        floor = new int[N + 1];
        visit = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++)
            floor[i] = Integer.parseInt(st.nextToken());

        char[] tmp = br.readLine().toCharArray();

        // 출발 사무실 찾기
        int start = S, speed = 0;
        for (char c : tmp) {
            if (c == '+') {
                speed += floor[start];
            } else if (c == '-') {
                speed -= floor[start];
            }
            start += speed;
        }

        System.out.println(start);
        check(start);
        System.out.print(res);
    }

    static void check(int start) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(start - floor[start], (-1) * floor[start], "-")); // 층수, 속도, 커맨드
        q.offer(new Node(start + floor[start], floor[start], "+"));

        int f, s;
        while (!q.isEmpty()) {
            Node now = q.poll();
            f = now.f;
            s = now.s;

            if (f < 0 || f > N)
                continue;

            if (f == S && s == 0) {
                res = now.cmd;
                return;
            }

            if (isPossible(f, s))
                q.offer(new Node(f + s, s, now.cmd + "0"));
            if (isPossible(f, s + floor[f]))
                q.offer(new Node(f + s + floor[f], s + floor[f], now.cmd + "+"));
            if (isPossible(f, s - floor[f]))
                q.offer(new Node(f + s - floor[f], s - floor[f], now.cmd + "-"));
        }
    }

    static boolean isPossible(int a, int b) {
        return (a + b > 0) && (a + b < N + 1);
    }
}
