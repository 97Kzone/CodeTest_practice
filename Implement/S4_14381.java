package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class S4_14381 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        String[] num;
        int N, std;

        HashSet<String> set = new HashSet<>();
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            if (N == 0) {
                sb.append("Case #" + t + ": INSOMNIA" + "\n");
                continue;
            }

            set.clear();
            std = N;
            for (int i = 1; i <= 100; i++) {
                std = N * i;
                num = String.valueOf(std).split("");
                for (String n : num) {
                    set.add(n);
                }

                if (set.size() == 10) {
                    break;
                }
            }

            sb.append("Case #" + t + ": " + std + "\n");
        }
        System.out.print(sb);
    }
}
