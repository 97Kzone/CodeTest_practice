package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S3_24468 {
    
    static class Ball {
        int pos;
        char dir;

        Ball(int pos, char dir) {
            this.pos = pos;
            this.dir = dir;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        Ball[] balls = new Ball[N + 1];
        int res = 0;

        int p;
        char d;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            p = Integer.parseInt(st.nextToken());
            d = st.nextToken().charAt(0);
            balls[i] = new Ball(p, d);
        }

        for (int t = 1; t <= T; t++) {
            List<Integer>[] box = new ArrayList[1001];

            for (int i = 0; i < 1001; i++) {
                box[i] = new ArrayList<>();
            }

            for (int i = 1; i <= N; i++) {
                Ball ball = balls[i];

                if (ball.dir == 'R') {
                    if (ball.pos == L) {
                        ball.dir = 'L';
                        ball.pos--;
                    } else {
                        ball.pos++;
                    }
                } else {
                    if (ball.pos == 0) {
                        ball.dir = 'R';
                        ball.pos++;
                    } else {
                        ball.pos--;
                    }
                }

                int idx = ball.pos;
                box[idx].add(i);

                if (box[idx].size() == 2) {
                    res++;
                    for (int b : box[idx]) {
                        balls[b].dir = (balls[b].dir == 'L') ? 'R' : 'L';
                    }
                }
            }
        }
        System.out.print(res);
    }
    
}
