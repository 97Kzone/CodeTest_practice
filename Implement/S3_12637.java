package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class S3_12637 {

    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        Map<Character, Integer> map;
        String s;
        int std, v;
        long res;
        for (int t = 1; t <= T; t++) {
            map = new HashMap<>();
            s = br.readLine();

            std = 2;
            for (int j = 0; j < s.length(); j++) {
                if (j == 0) {
                    map.put(s.charAt(j), 1); 
                }

                if (map.size() == 1 && !map.containsKey(s.charAt(j))) {
                    map.put(s.charAt(j), 0);
                }

                if (!map.containsKey(s.charAt(j))) {
                    map.put(s.charAt(j), std++);
                }
            }

            v = Math.max(map.size(), 2);
            
            res = 0;
            for (int j = s.length() - 1; j >= 0; j--) {
                res += (long) ((map.get(s.charAt(j)) * Math.pow(v, s.length() - 1 - j)));
            }

            bw.write("Case #" + t + ": " + res + "\n");
        }

        bw.flush();
        bw.close();
    }
}
