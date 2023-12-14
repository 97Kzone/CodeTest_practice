package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class G3_17497 {

    static long N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Long.parseLong(br.readLine());

        List<Character> res = new ArrayList<>();
        while (N != 0) {
            if ((N & 1) != 0) {
                res.add('/');
                N *= 2;
            } else if ((N & 2) != 0) {
                res.add('+');
                N -= 2;
            } else {
                res.add('*');
                N /= 2;
            }
        }

        if (res.size() > 99) {
            System.out.println("-1");
        } else {
            System.out.println(res.size());
            for (int i = res.size() - 1; i >= 0; i--) {
                System.out.print("[" + res.get(i) + "] ");
            }
        }
    }
}
