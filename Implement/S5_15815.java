package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class S5_15815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] s = br.readLine().toCharArray();
        Stack<Integer> stk = new Stack<>();

        int a, b;
        for (int i = 0; i < s.length; i++) {
            if (s[i] >= '0') {
                stk.push((s[i] - '0'));
                continue;
            }

            a = stk.pop();
            b = stk.pop();
            if (s[i] == '+') {
                stk.push(a + b);
            } else if (s[i] == '-') {
                stk.push(b - a);
            } else if (s[i] == '*') {
                stk.push(a * b);
            } else if (s[i] == '/') {
                stk.push(b / a);
            }
        }
        
        sb.append(stk.pop());
        System.out.print(sb);
    }
}
