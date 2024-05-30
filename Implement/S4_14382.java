package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class S4_14382 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int std, N, a, b;
        HashSet<Integer> set = new HashSet<>();
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            set.clear();

            boolean flag = false;
            b = N;
            for (int i = 1; i <= 100; i++) {
                std = i * N;
                b = i * N;
                while (std > 0) {
                    a = std % 10;
                    set.add(a);
                    std /= 10;
                }

                if (set.size() == 10) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                sb.append("Case #" + t + ": " + b + "\n");
            } else {
                sb.append("Case #" + t + ": INSOMNIA" + "\n");
            }
        }
        
        System.out.print(sb);
    }
}
