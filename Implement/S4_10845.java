package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class S4_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();

        String cmd;
        int n;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            cmd = st.nextToken();
            if ("push".equals(cmd)) {
                n = Integer.parseInt(st.nextToken());
                q.offer(n);
            } else if ("pop".equals(cmd)) {
                if(q.isEmpty()) sb.append("-1" + "\n");
                else sb.append(q.pollFirst() + "\n");
            } else if ("size".equals(cmd)) {
                sb.append(q.size() + "\n");
            } else if ("empty".equals(cmd)) {
                sb.append(q.isEmpty() ? 1 : 0).append("\n");
            } else if ("front".equals(cmd)) {
                if(q.isEmpty()) sb.append("-1" + "\n");
                else sb.append(q.peekFirst() + "\n");
            } else if ("back".equals(cmd)) {
                if(q.isEmpty()) sb.append("-1" + "\n");
                else sb.append(q.peekLast() +" \n");
            }
        }

        System.out.print(sb.toString());
    }
}
