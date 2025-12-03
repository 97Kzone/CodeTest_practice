package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class S5_24776 {

    static Map<String, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new HashMap<>();
        
        String name;
        while(true) {
            name = br.readLine();

            if ("***".equals(name)) break;

            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        String res = "";
        int cnt = 0;
        for (String key : map.keySet()) {
            if (map.get(key) > cnt) { 
                cnt = map.get(key);
                res = key;
            } else if (map.get(key) == cnt) {
                res = "Runoff!";
            }
        }

        System.out.print(res);
    }
}
