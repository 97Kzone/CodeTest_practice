package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_33967 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        char[] map = br.readLine().toCharArray();
        
        int res = 0;
        for (int i = 1; i < N; i++) {
            if (map[i] == '2' || map[i] == '5') {
                if (map[i] == map[i-1]) {
                    res += 2;
                    continue;
                }
            }
            if (map[i] == '[' && map[i-1] == ']') continue;
            res += 1;
        }

        System.out.print(res);
    }
}
