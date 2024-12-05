package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class S5_29808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int std = N / 4763;

        List<int[]> list = new ArrayList<>();
        if (Math.floor(std) != std) {
            sb.append("0");
        } else {
            for (int i = 0; i <= 200; i++) {
                for (int j = 0; j <= 200; j++) {
                    if (std == (i * 508) + (j * 212) ||
                            std == (i * 508) + (j * 305) ||
                            std == (i * 108) + (j * 212) ||
                            std == (i * 108) + (j * 305)) {
                        list.add(new int[] { i, j });
                    }
                }
            }

            sb.append(list.size() + "\n");
            for (int[] num : list) {
                sb.append(num[0] + " " + num[1] + "\n");
            }
        }
        System.out.print(sb);
    }
}
