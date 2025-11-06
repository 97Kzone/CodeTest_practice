package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class S1_30518 {
   static final int MOD = 1_000_000_007;
    static String lighter;
    static String smallant;
    static long avail;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        
        lighter = br.readLine();
        smallant = br.readLine();
        
        avail = 0;
        
        for (int i = 1; i <= smallant.length(); i++) {
            List<int[]> combinations = new ArrayList<>();
            comb(0, 0, i, new int[i], combinations);
            
            for (int[] tpl : combinations) {
                sb = new StringBuilder(lighter);
                for (int idx : tpl) {
                    sb.append(smallant.charAt(idx));
                }
                
                String string = sb.toString();
                
                if (check(string)) {
                    avail++;
                }
            }
        }
        
        System.out.print((avail % MOD) + "\n");
    }
    
    static void comb(int start, int depth, int r, int[] temp, List<int[]> result) {
        if (depth == r) {
            result.add(temp.clone());
            return;
        }
        
        for (int i = start; i < smallant.length(); i++) {
            temp[depth] = i;
            comb(i + 1, depth + 1, r, temp, result);
        }
    }
    
    static boolean check(String string) {
        for (int i = 0; i < string.length() - 2; i++) {
            char a = string.charAt(i);
            char b = string.charAt(i + 1);
            char c = string.charAt(i + 2);
            
            if (a == 'R' && b == 'S' && c == 'S') {
                return false;
            }
            if (a == 'S' && b == 'P' && c == 'P') {
                return false;
            }
            if (a == 'P' && b == 'R' && c == 'R') {
                return false;
            }
        }
        
        return true;
    }
}
