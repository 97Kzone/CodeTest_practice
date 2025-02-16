package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class S4_18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();
        
        String cmd;
        int X = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            cmd = st.nextToken();
            if (st.hasMoreTokens()) X = Integer.parseInt(st.nextToken());
            
            if ("push".equals(cmd)) {
                dq.add(X);
            } else if ("pop".equals(cmd)) {
                if (dq.isEmpty()) sb.append(-1 + "\n"); 
                else sb.append(dq.pop() + "\n");
            } else if ("size".equals(cmd)) {
                sb.append(dq.size() + "\n");
            } else if ("empty".equals(cmd)) {
                sb.append(dq.isEmpty() ? 1 : 0).append("\n");
            } else if ("front".equals(cmd)) {
                if (dq.isEmpty()) sb.append(-1 + "\n");
                else sb.append(dq.peekFirst() + "\n");
            } else if ("back".equals(cmd)) {
                if (dq.isEmpty()) sb.append(-1 + "\n");
                else sb.append(dq.peekLast() + "\n");
            }
        } 
        System.out.print(sb.toString());
    }
}
