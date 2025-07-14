package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class S2_31884 {
    
    static int Q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        Q = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();

        int cmd, idx, std;
        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());

            cmd = Integer.parseInt(st.nextToken());
            idx = Integer.parseInt(st.nextToken());

            // 1X4
            if (cmd == 1) {
                std = 0;
                for (int i = idx; i < idx + 4; i++) {
                    std = Math.max(std, map.getOrDefault(i, 0));
                }

                for (int i = idx; i < idx + 4; i++) {
                    map.put(i, std + 1);
                }
            } 
            // 4X1
            else if (cmd == 2) { 
                map.put(idx, map.getOrDefault(idx, 0) + 4);
            } else if (cmd == 3) {
                bw.write(map.getOrDefault(idx, 0) + "\n");
            }
        }
        
        bw.flush();
        bw.close();
    }
}
