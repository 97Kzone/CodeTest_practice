package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class S4_11344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        br.readLine();

        int N, v, cnt1, cnt2, std;
        String name, res;

        Queue<String> q = new ArrayDeque<>();
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            cnt1 = 0;
            cnt2 = 0;
            std = 0;
            q.clear();
            res = "";
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                name = st.nextToken();
                v = Integer.parseInt(st.nextToken());

                if (v == 15) {
                    if (cnt2 > 0) {
                        cnt2--;
                        q.poll();
                    } else cnt1++;
                } else {
                    if (cnt1 > 0) cnt1--;
                    else {
                        cnt2++;
                        q.offer(name);
                    }
                }

                if (cnt2 > std) {
                    res = "";
                    for (int j = 0; j < cnt2; j++) {
                        res += q.peek() + " ";
                        q.offer(q.poll());
                    }
                    std = cnt2;
                }
            }

            if ("".equals(res)) {
                bw.write("Line B stayed empty.");
            }
            bw.write(res + "\n");
            br.readLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
