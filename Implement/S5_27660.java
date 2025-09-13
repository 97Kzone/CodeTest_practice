package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class S5_27660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        int n, e, idx, std;
        int[] num, cmd;
        for (int t = 0; t < T; t++) {
            br.readLine();
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            num = new int[n+1];
            cmd = new int[e];
            for (int i = 1; i <= n; i++) {
                num[i] = i;
            }

            for (int i = 0; i < e; i++) {
                cmd[i] = Integer.parseInt(br.readLine());
            }

            std = 0;
            for (int i = e - 1; i >= 0; i--) {
                idx = cmd[i];
                if (num[idx] != 0) {
                    std = idx;
                    num[idx] = 0;
                }
            }

            for (int i = 1; i <= n; i++) {
                if (num[i] != 0) {
                    std = i;
                }
            }

            bw.write(std + "\n");
        }

        bw.flush();
        bw.close();
    }
}
