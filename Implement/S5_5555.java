package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_5555 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String target = br.readLine();
        int N = Integer.parseInt(br.readLine());
        String[] rings = new String[N];

        String s;
        for (int i = 0; i < N; i++) {
            s = br.readLine();

            rings[i] = s + s.substring(0, 9);
        }

        int res = 0;
        for (String ring : rings) {
            if (ring.contains(target)) {
                res++;
            }
        }

        System.out.print(res);
    }
}
