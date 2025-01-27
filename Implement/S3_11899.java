package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class S3_11899 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stk = new Stack<>();
        String s = br.readLine();
        int res = 0;

        char now;
        for (int i = 0; i < s.length(); i++) {
            now = s.charAt(i);
            if (now == ')') {
                if (stk.isEmpty()) res++;
                else stk.pop();
            } else {
                stk.add(now);
            }
        }

        res += stk.size();

        System.out.print(res);
    }
}
