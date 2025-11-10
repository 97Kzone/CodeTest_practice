package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class S3_33848 {

    static int Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        Q = Integer.parseInt(br.readLine());

        Stack<Integer> stk1 = new Stack<>();
        Stack<Integer> stk2 = new Stack<>();
        Stack<Integer> std = new Stack<>();

        int cmd, v;
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            cmd = Integer.parseInt(st.nextToken());

            if (cmd == 2) {
                stk2.push(stk1.pop());
                std.push(2);
                continue;
            }
            else if (cmd == 4) {
                bw.write(stk1.size() + "\n");
                continue;
            } else if (cmd == 5) {
                bw.write(stk1.isEmpty() ? "-1" : String.valueOf(stk1.peek()));
                bw.write("\n");
                continue;
            }

            v = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                stk1.push(v);
                std.push(1);
            } else if (cmd == 3) {
                while(v-- > 0) {
                    if (std.pop() == 1) {
                        if (stk1.isEmpty()) continue;
                        stk1.pop();
                    } else {
                        stk1.push(stk2.pop());
                    }
                }
            }
        }        
        
        bw.flush();
        bw.close();
        br.close();
    }
}
