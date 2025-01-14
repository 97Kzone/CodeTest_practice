package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class S3_15595 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        String[] s;

        String id;
        Integer std;
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");

            id = s[1];
            if (s[1].equals("megalusion")) continue;

            std = map.get(id);
            if (std == null) {
                std = 0;
            } else if (map.get(id) < 0) {
                continue;
            }
            std++;

            if (Integer.parseInt(s[2]) == 4) {
                cnt1++;
                cnt2 += std;
                std *= -1;
            }
            map.put(id, std);
        }
        
        double res;
        if (cnt2 == 0) {
            res = 0;
        } else {
            res = (double) cnt1 / (double) cnt2;
        }
        System.out.print(res*100);

        
    }
}
