package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_11916 {

    static boolean one, two, thr;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ball = 0;

        while (n-- > 0) {
            int num = Integer.parseInt(st.nextToken());

            if (num == 1) {
                if (++ball == 4) {
                    advance(0);
                    ball = 0;
                }
            } else if (num == 2) {
                advance(0);
                ball = 0;
            } else {
                advance(1);
                if (++ball == 4) {
                    advance(0);
                    ball = 0;
                }
            }
        }

        System.out.println(count);
    }

    static void advance(int type) {
        if (type == 0) {
            if (one) {
                if (two) {
                    if (thr) count++;
                    thr = true;
                } else {
                    two = true;
                }
            }
            one = true;
        } else {
            if (thr) {
                count++;
                thr = false;
            }
            if (two) {
                thr = true;
                two = false;
            }
            if (one) {
                two = true;
                one = false;
            }
        }
    }
}
