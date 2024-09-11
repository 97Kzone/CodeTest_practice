package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class S5_25497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        char[] cmd = br.readLine().toCharArray();
        
        Stack<Character> stk1 = new Stack<>();
        Stack<Character> stk2 = new Stack<>();
        int res = 0;
        for (int i = 0; i < N; i++) {
            if (cmd[i] == 'L') {
                stk1.add(cmd[i]);
            } else if (cmd[i] == 'S') {
                stk2.add(cmd[i]);
            } else if (cmd[i] == 'R') {
                if (stk1.isEmpty())
                    break;
                if (stk1.peek() == 'L') {
                    res++;
                } else
                    break;
                stk1.pop();
            } else if (cmd[i] == 'K') {
                if (stk2.isEmpty())
                    break;
                if (stk2.peek() == 'S') {
                    res++;
                } else
                    break;
                stk2.pop();
            } else {
                res++;
            }
        }

        System.out.print(res);
    }
}
