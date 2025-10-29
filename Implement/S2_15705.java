package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S2_15705 {
    static int a, b, len;
    static String s;
    static char[][] arr;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        s = br.readLine();
        len = s.length();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        
        arr = new char[a][b];
        for (int i = 0; i < a; i++) {
            String line = br.readLine();
            for (int j = 0; j < b; j++) {
                arr[i][j] = line.charAt(j);
            }
        }
        
        boolean found = false;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (arr[i][j] == s.charAt(0)) {
                    if (check(i, j)) {
                        found = true;
                        break;
                    }
                }
            }
            if (found) break;
        }
        
        bw.write(found ? "1\n" : "0\n");
        
        bw.flush();
        bw.close();
    }
    
    static boolean check(int x, int y) {
        for (int i = 0; i < 8; i++) {
            boolean valid = true;
            
            for (int j = 0; j < len; j++) {
                int nx = x + dx[i] * j;
                int ny = y + dy[i] * j;
                
                if (nx < 0 || ny < 0 || nx >= a || ny >= b) {
                    valid = false;
                    break;
                }
                
                if (arr[nx][ny] != s.charAt(j)) {
                    valid = false;
                    break;
                }
            }
            
            if (valid) return true;
        }
        
        return false;
    }

}
