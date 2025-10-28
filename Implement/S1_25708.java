package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S1_25708 {

    static int N, M;
    static int[][] graph;
    static int[] rowSum;
    static int[] colSum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        graph = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int sum;
        rowSum = new int[N];
        for (int i = 0; i < N; i++) {
            sum = 0;
            for (int j = 0; j < M; j++) {
                sum += graph[i][j];
            }
            rowSum[i] = sum;
        }
        
        colSum = new int[M];
        for (int j = 0; j < M; j++) {
            sum = 0;
            for (int i = 0; i < N; i++) {
                sum += graph[i][j];
            }
            colSum[j] = sum;
        }
        
        List<int[]> rowCombination = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                rowCombination.add(new int[]{i, j});
            }
        }
        
        List<int[]> colCombination = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = i + 1; j < M; j++) {
                colCombination.add(new int[]{i, j});
            }
        }
        
        long answer = Long.MIN_VALUE;
        
        for (int[] rc : rowCombination) {
            int i1 = rc[0];
            int i2 = rc[1];
            
            for (int[] cc : colCombination) {
                int j1 = cc[0];
                int j2 = cc[1];

                int duplicate = graph[i1][j1] + graph[i1][j2] + graph[i2][j1] + graph[i2][j2];
                long temp = (long)rowSum[i1] + rowSum[i2] + colSum[j1] + colSum[j2] - duplicate + 
                           ((long)(i2 - i1 - 1) * (j2 - j1 - 1));
                
                answer = Math.max(answer, temp);
            }
        }
        
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }
}
