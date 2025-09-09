package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class S3_34075 {

    static int N, M, Q;
    static Map<String, Integer> algo, tier;
    static String curName; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        algo = new TreeMap<>();
        tier = new HashMap<>();

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            algo.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }
        
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            tier.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        Q = Integer.parseInt(br.readLine());
        String[] cmd = new String[3];
        String res1, res2;
        int lv1, lv2, std, tmp;
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cmd[j] = st.nextToken();
            }
            
            res1 = "";
            res2 = "";
            
            if ("-".equals(cmd[1])) {
                curName = cmd[0]; 
                bw.write("hai!" + "\n");
            } else {
                lv1 = tier.get(curName);
                std = 31;

                for (String name : algo.keySet()) {
                    lv2 = algo.get(name);
                    tmp = Math.abs(lv1 - lv2);
                    
                    if (tmp < std) {
                        std = tmp;
                        res1 = name;
                    }
                }

                std = 31;
                for (String name : algo.keySet()) {
                    if (name.equals(res1)) continue;

                    lv2 = algo.get(name);
                    tmp = Math.abs(lv1 - lv2);
                    
                    if (tmp < std) {
                        std = tmp;
                        res2 = name;
                    }
                }

                bw.write(res2 + " yori mo " + res1 + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}