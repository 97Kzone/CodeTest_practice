package GAJI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class A {
    static int N, M, K;
    static String[] words;
    static Set<String> gaji;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        words = br.readLine().split(" ");
        gaji = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 조수들 가지
        Set<String> tmp = new HashSet<>();
        for (int i = 0; i < M; i++) {
            tmp.clear();
            st = new StringTokenizer(br.readLine());

            int v;
            for (int j = 0; j < K; j++) {
                v = Integer.parseInt(st.nextToken());
                tmp.add(words[v - 1]);
            }

            if (tmp.size() == 1) { // 종류가 1개면 그대로 삽입
                if (tmp.contains("W")) {
                    gaji.add("W");
                } else {
                    gaji.add("P");
                }
            } else {
                gaji.add("P");
            }

        }

        String res;
        if (gaji.size() == 1) {
            if (gaji.contains("P")) {
                res = "P";
            } else {
                res = "W";
            }
        } else {
            res = "W";
        }

        System.out.println(res);
    }
}
