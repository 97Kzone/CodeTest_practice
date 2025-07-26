package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S1_10515 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int D, K, S, idx, nxt;
        List<Integer> list, std;
        for (int t = 1; t <= N; t++) {
            st = new StringTokenizer(br.readLine());
            list = new ArrayList<>();
            
            D = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());
            
            list.add(0);
            for (int i = 0; i < S; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            list.add(D);

            std = new ArrayList<>();
            idx = 0;
            while (idx < list.size() - 1) {
                nxt = idx;
                while (nxt + 1 < list.size() && list.get(nxt + 1) - list.get(idx) <= K) {
                    nxt++;
                }

                if (nxt == idx) {
                    bw.write("Case #" + t + ": out of petrol\n");
                    break;
                }

                std.add(list.get(nxt));
                idx = nxt;
            }


            if (idx == list.size() - 1) {
                bw.write("Case #" + t + ": ");
                for (int i = 0; i < std.size() - 1; i++) {
                    bw.write(std.get(i) + " ");
                }
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
