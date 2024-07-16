package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.StringTokenizer;

public class S2_27497 {
    
    static class Node {
        String s;
        int idx;

        Node(String s, int idx) {
            this.s = s;
            this.idx = idx;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int N;
        ArrayDeque<Node> dq = new ArrayDeque<>();
        N = Integer.parseInt(br.readLine());

        int a;
        String b;
        int idx = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());

            if (a == 1) {
                b = st.nextToken();
                dq.addLast(new Node(b, idx++));
            } else if (a == 2) {
                b = st.nextToken();
                dq.addFirst(new Node(b, idx++));
            } else {
                if (dq.size() == 0) {
                    continue;
                } else if (dq.size() == 1) {
                    dq.pollFirst();
                } else {
                    Node n1 = dq.peekFirst();
                    Node n2 = dq.peekLast();

                    if (n1.idx > n2.idx) {
                        dq.pollFirst();
                    } else {
                        dq.pollLast();
                    }
                }
            }
        }

        if (dq.isEmpty()) {
            System.out.print(0);
            return;
        }
        
        while (!dq.isEmpty()) {
            sb.append(dq.pollFirst().s);
        }

        System.out.print(sb);
    }
}
