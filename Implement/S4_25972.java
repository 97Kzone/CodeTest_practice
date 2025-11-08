package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_25972 {

    static int N;
    static int[][] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        arr = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
        
        int answer = 1;
        int[] prev = arr[0];
        
        for (int i = 1; i < N; i++) {
            int[] cur = arr[i];
            
            if (prev[0] + prev[1] < cur[0]) {
                answer++;
            }
            
            prev = cur;
        }
        
        System.out.print(answer);
    }
}
