package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_16567 {

    static int N, M;
    static int[] road;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        road = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        boolean inSegment = false;
        for (int i = 1; i <= N; i++) {
            if (road[i] == 1) {
                if (!inSegment) {
                    cnt++;
                    inSegment = true;
                }
            } else {
                inSegment = false;
            }
        }

        int cmd, v;
        boolean left, right;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            cmd = Integer.parseInt(st.nextToken());

            if (cmd == 0) {
                sb.append(cnt).append("\n");
                continue;
            }

            v = Integer.parseInt(st.nextToken());
            if (road[v] == 1) continue;
            road[v] = 1;

            left = (v > 1 && road[v - 1] == 1);
            right = (v < N && road[v + 1] == 1);

            if (left && right) {
                cnt--;
            } else if (!left && !right) {
                cnt++;
            }
        }

        System.out.print(sb);
    }
}
