package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_2195 {

    static int res, sl, pl;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        res = 0;
        String s = br.readLine();
        String p = br.readLine();

        int idx = 0; // 비교할 위치

        sl = s.length();
        pl = p.length();
        for (int i = 0; i < pl; i++) {
            if (s.indexOf(p.substring(idx, i + 1)) != -1) continue;

            res++;
            idx = i;
        }
        
        System.out.print(res + 1);
    }
    
}
