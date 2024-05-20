package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class S3_17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] words = br.readLine().split("");
        Stack<String> stk = new Stack<>();


        boolean flag = false;
        for (String s : words) {
            if ("<".equals(s)) {
                while (!stk.isEmpty()) {
                    sb.append(stk.pop());
                }

                sb.append(s);
                flag = true;
                continue;
            }

            if (" ".equals(s)) {
                while (!stk.isEmpty()) {
                    sb.append(stk.pop());
                }
                sb.append(s);
                continue;
            }

            if (">".equals(s)) {
                flag = false;
                sb.append(s);
                continue;
            }

            if (flag) {
                sb.append(s);
                continue;
            }

            stk.add(s);
        }
        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }

        System.out.print(sb.toString());
    }
}
