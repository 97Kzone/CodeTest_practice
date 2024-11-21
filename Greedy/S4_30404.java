package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_30404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        
        int cnt = 0;
        int std = 0;
        int tmp;
        for (int i = 0; i < N; i++) {
            tmp = Integer.parseInt(st.nextToken());

            if (i == 0) std = tmp;
            
            if (std + K < tmp) {
                cnt++;
                std = tmp;
            }
        }
        System.out.print(cnt + 1);

    }
}
