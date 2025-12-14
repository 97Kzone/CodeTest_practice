package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S2_18442 {
    static int V, P;
    static long L;
    static long[] village, selected, answer;
    static long minSum = Long.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        V = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        L = Long.parseLong(st.nextToken());
        
        village = new long[V];
        selected = new long[P];
        answer = new long[P];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < V; i++) {
            village[i] = Long.parseLong(st.nextToken());
        }
        
        check(0, 0);
        
        bw.write(minSum + "\n");
        for (long loc : answer) {
            bw.write(loc + " ");
        }
        bw.write("\n");
        
        bw.flush();
        bw.close();
    }
    
    static void check(int start, int cnt) {
        if (cnt == P) {
            calcDist();
            return;
        }
        
        for (int i = start; i < V; i++) {
            selected[cnt] = village[i];
            check(i + 1, cnt + 1);
        }
    }
    
    static void calcDist() {
        long sum = 0;
        
        for (int i = 0; i < V; i++) {
            long minDist = Long.MAX_VALUE;
            
            for (int j = 0; j < P; j++) {
                long dist = getDist(village[i], selected[j]);
                minDist = Math.min(minDist, dist);
            }
            
            sum += minDist;
        }
        
        if (sum < minSum) {
            minSum = sum;
            answer = selected.clone();
        }
    }
    
    static long getDist(long a, long b) {
        long direct = Math.abs(a - b);  
        long around = Math.min(a, b) + L - Math.max(a, b);  
        return Math.min(direct, around);
    }
}