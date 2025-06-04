package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class S4_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s;
        while(true) {
            s = br.readLine();

            if (".".equals(s)) break;

            sb.append(check(s) ? "yes" : "no").append("\n");
        }

        System.out.print(sb.toString());
    }

    static boolean check(String s) {
        Stack<Character> stk = new Stack<>();
        
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);

            if (c == '(' || c == '[') {
                stk.push(c);
            } else if (c == ')') {
                if (stk.isEmpty() || stk.peek() != '(') return false;
                stk.pop();
            } else if (c == ']') {
                if (stk.isEmpty() || stk.peek() != '[') return false;
                stk.pop();
            }
        }

        return stk.isEmpty();
    }
}
