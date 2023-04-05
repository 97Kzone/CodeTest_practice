package KY2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 홀, 짝 기준을 이용하여 O(N) 으로 주파해보기
public class B {
    static int N;
    static int oStd = -1, eStd = -1;
    static int v1, v2; // 결과값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        // 초기화
        v1 = 987654321;
        v2 = 987654321;

        int n, t;
        for (int i = 0; i < N; i++) {
            n = Integer.parseInt(st.nextToken());
            if (n % 2 == 0) { // 짝수일 때
                if (eStd == -1) {
                    eStd = n;

                    if (oStd == -1) {
                        continue;
                    } else {
                        t = n - oStd;
                        check(t);
                    }
                    continue;
                }

                t = n - eStd;
                check(t);

                // 짝수랑 연산 될까요 ?
                if (oStd == -1) {
                    eStd = n;
                    continue; // 아니요
                }

                t = n - oStd;
                check(t);

                eStd = n;
            } else { // 홀수 일 때
                // 홀수가 첫 등장이면 n 을 넣어주고 다음
                if (oStd == -1) {
                    oStd = n;

                    // 짝수랑 연산 가능?
                    if (eStd == -1) {
                        continue;
                    } else {
                        t = n - eStd;
                        check(t);
                    }
                    continue;
                }

                // 홀수는 있고 짝수가 있는지 판단 필요
                t = n - oStd;
                check(t);

                // 짝수랑 연산 될까요 ?
                if (eStd == -1) {
                    oStd = n;
                    continue; // 아니요
                }

                t = n - eStd;
                check(t);

                oStd = n;
            }
        }
        v1 = v1 == 987654321 ? -1 : v1;
        v2 = v2 == 987654321 ? -1 : v2;
        System.out.println(v1 + " " + v2);
    }

    static void check(int t) {
        if (t % 2 == 0) {
            if (t < v1)
                v1 = t;
        } else {
            if (t < v2)
                v2 = t;
        }
    }
}
