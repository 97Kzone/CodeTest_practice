package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_25185 {

    static String[] a = new String[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                a[i] = st.nextToken();
            }
            Arrays.sort(a);

            if (check1() || check2() || check3()) {
                sb.append(":)").append("\n");
            } else {
                sb.append(":(").append("\n");
            }
        }
        System.out.print(sb);
    }

    static boolean check1() {
        int[][] indices = {{0, 1, 2}, {0, 1, 3}, {0, 2, 3}, {1, 2, 3}};
        for (int[] idx : indices) {
            if (a[idx[0]].charAt(1) == a[idx[1]].charAt(1) && a[idx[0]].charAt(1) == a[idx[2]].charAt(1)) {
                int num1 = a[idx[0]].charAt(0) - '0';
                int num2 = a[idx[1]].charAt(0) - '0';
                int num3 = a[idx[2]].charAt(0) - '0';
                if (num2 - num1 == 1 && num3 - num2 == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean check2() {
        for (int i = 0; i < 2; i++) {
            int count = 0;
            for (String card : a) {
                if (card.equals(a[i])) {
                    count++;
                }
            }
            if (count >= 3) {
                return true;
            }
        }
        return false;
    }

    static boolean check3() {
        int[][] indices = {{0, 1, 2, 3}, {0, 2, 1, 3}, {0, 3, 1, 2}};
        for (int[] idx : indices) {
            if (a[idx[0]].equals(a[idx[1]]) && a[idx[2]].equals(a[idx[3]])) {
                return true;
            }
        }
        return false;
    }
}
