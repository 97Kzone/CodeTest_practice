package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class S5_25206 {

    static HashMap<String, Double> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        init();

        double res = 0.0;
        double score = 0.0;
        double sum = 0.0;

        String[] s;
        for (int i = 0; i < 20; i++) {
            s = br.readLine().split(" ");

            if ("P".equals(s[2]))
                continue;
            
            res += Double.parseDouble(s[1]) * map.get(s[2]);
            sum += Double.parseDouble(s[1]);
        }
        System.out.print(res / sum);
    }
    
    static void init() {
        map = new HashMap<>();

        map.put("A+", 4.5);
        map.put("A0", 4.0);
        map.put("B+", 3.5);
        map.put("B0", 3.0);
        map.put("C+", 2.5);
        map.put("C0", 2.0);
        map.put("D+", 1.5);
        map.put("D0", 1.0);
        map.put("F", 0.0);
    }
}
