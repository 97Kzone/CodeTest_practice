package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class S5_15720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        Integer[] burger = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] side = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] drink = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        Arrays.sort(burger, Collections.reverseOrder());
        Arrays.sort(side, Collections.reverseOrder());
        Arrays.sort(drink, Collections.reverseOrder());

        int result = 0;
        int min_value = Math.min(b, Math.min(c, d));
        for (int i = 0; i < min_value; i++) {
            result += (burger[i] + side[i] + drink[i]) * 0.9;
        }

        for (int i = min_value; i < b; i++) {
            result += burger[i];
        }
        for (int i = min_value; i < c; i++) {
            result += side[i];
        }
        for (int i = min_value; i < d; i++) {
            result += drink[i];
        }

        System.out.println(Arrays.stream(burger).mapToInt(Integer::intValue).sum() +
                Arrays.stream(side).mapToInt(Integer::intValue).sum() +
                Arrays.stream(drink).mapToInt(Integer::intValue).sum());
        System.out.println(result);
    }
}
