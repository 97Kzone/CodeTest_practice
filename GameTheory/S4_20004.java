package GameTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S4_20004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int std;
        for (int i = 1; i <= N; i++) {
            std = i + 1;

            if (30 % std == 0) sb.append(i + "\n");
        }
        
        System.out.print(sb);
    }
}
