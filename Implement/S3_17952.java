package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class S3_17952 {
    static int N;
    static Stack<int[]> stk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        stk = new Stack<>();

        N = Integer.parseInt(br.readLine());
        
        int s, t;
        int res = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            if ("1".equals(st.nextToken())) {
                s = Integer.parseInt(st.nextToken());
                t = Integer.parseInt(st.nextToken());

                if (t == 1)
                    res += s;
                else {
                    stk.push(new int[] { s, t - 1 });
                }
            } else if (!stk.isEmpty()) {
                int[] tmp = stk.pop();

                tmp[1]--;
                if (tmp[1] == 0)
                    res += tmp[0];
                else {
                    stk.push(tmp);
                }
            }
        }
        System.out.print(res);
    }
}
