package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_27965 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int mod = Integer.parseInt(st.nextToken());
        int res = 0;
        
        int std;
        for (int i = 1; i <= N; i++) {
            int tns = 1;
            std = String.valueOf(i).length();
            
            for (int j = 0; j < std; j++) {
                tns *= 10;
            }
            
            res = (int) ((res * (long) tns % mod + i) % mod);
        }
        
        System.out.println(res);
    }
}
