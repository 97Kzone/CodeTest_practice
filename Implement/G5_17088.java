package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class G5_17088 {

    static int N;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int result = check();
        
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
    
    static int check() {
        if (N == 1) return 0;
        
        int min = Integer.MAX_VALUE;
        
        int a1, a2;
        int diff, prev;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                a1 = arr[0] + i;
                a2 = arr[1] + j;
                
                diff = a2 - a1;
                prev = a2;
                
                boolean flag = true;
                int cnt = 0;
                
                for (int k = 2; k < N; k++) {
                    int make = arr[k] - prev - diff;
                    prev = arr[k] - make;
                    
                    if (make < -1 || make > 1) {
                        flag = false;
                        continue;
                    }
                    
                    if (make != 0) cnt++;
                }
                
                if (i != 0) cnt++;
                if (j != 0) cnt++;
                if (flag) min = Math.min(min, cnt);
            }
        }
        
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
