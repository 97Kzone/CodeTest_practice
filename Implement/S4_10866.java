package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class S4_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();

        String cmd;
        int v;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            cmd = st.nextToken();

            if (cmd.startsWith("push")) {
                v = Integer.parseInt(st.nextToken());

                if ("push_back".equals(cmd)) dq.addLast(v);
                else dq.addFirst(v);
            
            } else {
                if ("front".equals(cmd)) {
                    if (dq.isEmpty())
                        sb.append("-1" + "\n");
                    else
                        sb.append(dq.peekFirst()).append("\n");
                } else if ("back".equals(cmd)) {
                    if (dq.isEmpty())
                        sb.append("-1" + "\n");
                    else
                        sb.append(dq.peekLast()).append("\n");
                } else if ("size".equals(cmd)) {
                    sb.append(dq.size()).append("\n");
                } else if ("empty".equals(cmd)) {
                    if (dq.isEmpty()) {
                        sb.append("1" + "\n");
                    } else {
                        sb.append("0" + "\n");
                    }
                } else if (("pop_front").equals(cmd)) {
                    if (dq.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(dq.pollFirst()).append("\n");
                } else if (("pop_back".equals(cmd))) {
                    if (dq.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(dq.pollLast()).append("\n");
                }
            }
            
        }
        System.out.print(sb);
        
    }
}
