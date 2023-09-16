package contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {

    static int A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        int res = 0;
        // 1. 패티와 치즈가 같다면
        if (A == B) {
            res = A + (A - 1);
        } else if (A > B) {
            res = B + B + 1;
        } else {
            res = A + (A - 1);
        }

        System.out.print(res);
    }
}
