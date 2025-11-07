package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class S2_28242 {
    
    static int N;
    static List<int[]> list1, list2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        list1 = getPair(N);
        list2 = getPair(-(N + 2));

        int a = 0, b = 0, c = 0, d = 0;
        for (int[] num1 : list1) {
            a = num1[0];
            c = num1[1];

            for (int[] num2 : list2) {
                b = num2[0];
                d = num2[1];

                if ((a * d) + (b * c) == N + 1) {
                    System.out.print(a + " " + b + " " + c + " " + d);
                    return;
                }
            }
        }

        System.out.print(-1);
    }

    static List<int[]> getPair(int n) {
        List<int[]> result = new ArrayList<>();

        if (n == 0) return result;

        int std = Math.abs(n);
        int j;
        for (int i = 1; i * i <= std; i++) {
            if (std % i == 0) {
                j = std / i;

                if (n > 0) {
                    result.add(new int[] {i, j});
                    result.add(new int[] {-i, -j});

                    if (i != j) {
                        result.add(new int[] {j, i});
                        result.add(new int[] {-j, -i});
                    }
                } else {
                    result.add(new int[] {i, -j});
                    result.add(new int[] {-i, j});

                    if (i != j) {
                        result.add(new int[] {j, -i});
                        result.add(new int[] {-j, i});
                    }
                }
            }
        }

        return result;
    }
}
