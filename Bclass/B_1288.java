package Bclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1288 {
    static int N, std;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            std = 0; 

            int cnt = 1;
            while (true) {
                std = std | (N*cnt);
                
                System.out.println(N + " " + std);
                if (std == 1024) {
                    sb.append("#" + t + " ").append(N + "\n");
                    break;
                }
                cnt++;
            }
        }
        
        System.out.println(sb.toString());
    }
}
