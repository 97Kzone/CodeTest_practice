package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_1755 {
    
    static int N, M;
    static int[] map = {8, 5, 4, 9, 1, 7, 6, 3, 2, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int cnt = 0;
        int std;
        for (int i = 0; i < 10; i++) {
            if (map[i] >= M && map[i] <= N) {
                sb.append(map[i] + " ");
                cnt++;
                if (cnt % 10 == 0) sb.append("\n"); 
            }

            if (map[i] * 10 < M - 10) continue;
            for (int j = 0; j < 10; j++) {
                std = map[i] * 10 + map[j];
                if (std < 10 || std < M || std > N) continue;
                sb.append(std + " ");
                cnt++;
                if (cnt % 10 == 0) sb.append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}
