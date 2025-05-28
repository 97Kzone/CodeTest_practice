package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class S4_9012 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        String s;
        Stack<Character> stk;
        char std;
        for (int i = 0; i < N; i++) {
            stk = new Stack<>();
            s = br.readLine();

            for (int j = 0; j < s.length(); j++) {
                if (stk.isEmpty()) {
                    stk.push(s.charAt(j));
                } else {
                    std = stk.peek();
                    if (std == '(') {
                        if (s.charAt(j) == ')') stk.pop();
                        else stk.push(s.charAt(j));
                    } else {
                        stk.push(s.charAt(j));
                    }
                }
            }

            sb.append(stk.isEmpty() ? "YES" : "NO").append("\n");
        }

        System.out.print(sb.toString());
    }
}
