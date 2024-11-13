package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S4_14468 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        
        int[] check1 = new int[26];
        int[] check2 = new int[26];
        int cnt = 0;

        int idx;
        for (int i = 0; i < 52; i++) {
            idx = s.charAt(i) - 'A';
            if (check1[idx] == 0) check1[idx] = i + 1;
            else check2[idx] = i + 1;
        }
        
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (check1[i] >= check1[j]) continue;
                if (check1[j] >= check2[i]) continue;
                if (check2[i] >= check2[j]) continue;

                cnt++;
            }
        }
        System.out.print(cnt);
    }
}
