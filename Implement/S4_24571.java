package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class S4_24571 {
    static int X, Y, G;
    static HashMap<String, Integer> group;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        X = Integer.parseInt(br.readLine());
        
        int cnt = 0;
        String[][] std = new String[X][2];
        
        for (int i = 0; i < X; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            std[i][0] = st.nextToken();
            std[i][1] = st.nextToken();
        }
        
        Y = Integer.parseInt(br.readLine());
        String[][] std2 = new String[Y][2];
        
        for (int i = 0; i < Y; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            std2[i][0] = st.nextToken();
            std2[i][1] = st.nextToken();
        }
        
        G = Integer.parseInt(br.readLine());
        group = new HashMap<>();
        
        for (int g = 0; g < G; g++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int k = 0; k < 3; k++) {
                group.put(st.nextToken(), g);
            }
        }
        
        for (int i = 0; i < X; i++) {
            int g1 = group.get(std[i][0]);
            int g2 = group.get(std[i][1]);
            if (g1 != g2) cnt++;
        }
        
        for (int i = 0; i < Y; i++) {
            int g1 = group.get(std2[i][0]);
            int g2 = group.get(std2[i][1]);
            if (g1 == g2) cnt++;
        }
        
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }
}