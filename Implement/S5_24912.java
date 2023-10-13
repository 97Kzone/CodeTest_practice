package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

public class S5_24912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] Cards = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

        if (N == 1) {
            if (Cards[0] == 0) {
                System.out.println(1);
            } else {
                System.out.println(Cards[0]);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (Cards[i] == 0) {
                int num = 0;
                if (i == 0) {
                    for (int j = 1; j <= 3; j++) {
                        if (Cards[1] != j) {
                            num = j;
                            break;
                        }
                    }
                } else if (i == (N - 1)) {
                    for (int j = 1; j <= 3; j++) {
                        if (Cards[N - 2] != j) {
                            num = j;
                            break;
                        }
                    }
                } else {
                    for (int j = 1; j <= 3; j++) {
                        Set<Integer> adjacentValues = new HashSet<>();
                        adjacentValues.add(Cards[i - 1]);
                        adjacentValues.add(Cards[i + 1]);
                        if (!adjacentValues.contains(j)) {
                            num = j;
                            break;
                        }
                    }
                }
                Cards[i] = num;
            }

            if (i > 0 && Cards[i - 1] == Cards[i]) {
                System.out.println(-1);
                return;
            }
        }

        StringJoiner sj = new StringJoiner(" ");
        Arrays.stream(Cards).forEach(card -> sj.add(String.valueOf(card)));
        System.out.println(sj.toString());
    }
}
