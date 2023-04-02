package GahuiCup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B {
    static int res = 86400;
    static int c, h;
    static Queue<Integer> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        c = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        pq = new PriorityQueue<>();

        for (int i = 0; i < c + h; i++) {
            pq.offer(time2min(br.readLine().split(":")));
        }

        check();
        System.out.println(res);
    }

    static void check() {

        int s = pq.poll(); // 초기 세팅
        int cnt = s; // 중간마다 갱신되는 열차

        while (!pq.isEmpty()) {
            // 만약 40초안에 반대 열차가 지나가면 연장
            if (cnt + 40 > pq.peek()) {
                cnt = pq.poll();
            } else {
                res -= cnt + 40 - s;
                s = pq.poll();
                cnt = s;
            }
        }

        res -= cnt + 40 - s;
    }

    static int time2min(String[] s) {
        return Integer.parseInt(s[0]) * 3600 +
                Integer.parseInt(s[1]) * 60 +
                Integer.parseInt(s[2]);
    }
}
