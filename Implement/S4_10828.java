package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class S4_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Stack<Integer> stk = new Stack<>();
        int N = Integer.parseInt(br.readLine());

        String cmd;
        int X;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            cmd = st.nextToken();
            if ("push".equals(cmd)) {
                X = Integer.parseInt(st.nextToken());
                stk.push(X);
            } else if ("pop".equals(cmd)) {
                sb.append(!stk.isEmpty() ? stk.pop() : -1).append("\n");
            } else if ("top".equals(cmd)) {
                sb.append(stk.isEmpty() ? -1 : stk.peek()).append("\n");
            } else if ("size".equals(cmd)) {
                sb.append(stk.size()).append("\n");
            } else if ("empty".equals(cmd)) {
                sb.append(stk.isEmpty() ? 1 : 0).append("\n");
            }
        }
        System.out.print(sb.toString());
    }
}
