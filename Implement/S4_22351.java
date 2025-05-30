package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class S4_22351 {

    static int size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String num = br.readLine();
        size = num.length();

        List<Integer> cand = new ArrayList<>();
        if (size < 2) { // 1자리
            cand.add(Integer.parseInt(num.substring(0, 1)));
        } else if (size < 3) { // 2자리
            cand.add(Integer.parseInt(num.substring(0, 1)));
            cand.add(Integer.parseInt(num.substring(0, 2)));
        } else {
            cand.add(Integer.parseInt(num.substring(0, 1)));
            cand.add(Integer.parseInt(num.substring(0, 2)));
            cand.add(Integer.parseInt(num.substring(0, 3)));
        }

        int b;
        String std;
        boolean flag = true;
        for (int a : cand) {
            b = a;
            std = "";

            while (std.length() < size) {
                std += b;
                if (num.equals(std)) {
                    sb.append(a + " " + b);
                    flag = false;
                    break;
                }
                b++;
            }

            if (!flag) break;
        }

        System.out.print(sb.toString());
    }
}
