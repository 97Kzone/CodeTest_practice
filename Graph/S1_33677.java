package Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class S1_33677 {
    static final int INF = (int) 1e9;
    static int N;
    static int[] days;
    static int[] water;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        
        if (N == 0) {
            bw.write("0 0\n");
            bw.flush();
            bw.close();
            return;
        }
        
        days = new int[N + 1];
        water = new int[N + 1];
        Arrays.fill(days, INF);
        Arrays.fill(water, INF);
        days[0] = 0;
        water[0] = 0;
        
        check();
        
        bw.write(days[N] + " " + water[N] + "\n");
        bw.flush();
        bw.close();
    }
    
    static void check() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            int nextDay = days[cur] + 1;
            
            if (cur + 1 <= N) {
                int newWater = water[cur] + 1;
                if (days[cur + 1] > nextDay) {
                    days[cur + 1] = nextDay;
                    water[cur + 1] = newWater;
                    q.offer(cur + 1);
                } else if (days[cur + 1] == nextDay && water[cur + 1] > newWater) {
                    water[cur + 1] = newWater;
                    q.offer(cur + 1);
                }
            }
            
            if (cur > 0 && cur * 3 <= N) {
                int newVal = cur * 3;
                int newWater = water[cur] + 3;
                
                if (days[newVal] > nextDay) {
                    days[newVal] = nextDay;
                    water[newVal] = newWater;
                    q.offer(newVal);
                } else if (days[newVal] == nextDay && water[newVal] > newWater) {
                    water[newVal] = newWater;
                    q.offer(newVal);
                }
            }
            
            if (cur > 1 && (long) cur * cur <= N) {
                int newVal = cur * cur;
                int newWater = water[cur] + 5;
                
                if (days[newVal] > nextDay) {
                    days[newVal] = nextDay;
                    water[newVal] = newWater;
                    q.offer(newVal);
                } else if (days[newVal] == nextDay && water[newVal] > newWater) {
                    water[newVal] = newWater;
                    q.offer(newVal);
                }
            }
        }
    }
}