package KY2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        char[] ch = s.toCharArray();

        int v1 = 0, v2 = 0;

        char[] std = { 'Y', 'O', 'N', 'S', 'E', 'I' };
        char[] std2 = { 'K', 'O', 'R', 'E', 'A' };

        // YONSEI 찾기
        int idx = 0;
        for (int i = 0; i < ch.length; i++) {
            if (std[idx] == ch[i]) {
                idx++;
            }

            if (idx == 6) {
                v1 = i;
                break;
            }
        }

        idx = 0;
        for (int i = 0; i < ch.length; i++) {
            if (std2[idx] == ch[i]) {
                idx++;
            }

            if (idx == 5) {
                v2 = i;
                break;
            }
        }

        if (v1 != 0 && v2 != 0) {
            System.out.println(v1 < v2 ? "YONSEI" : "KOREA");
        } else if (v1 != 0) {
            System.out.println("YONSEI");
        } else if (v2 != 0) {
            System.out.println("KOREA");
        }
    }
}
