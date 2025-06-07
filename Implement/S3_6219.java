package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S3_6219 {

    static int A, B, D;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        check();

        int res = 0;
        for (int num : list) {
            while(num != 0) {
                if (num % 10 == D) {
                    res++;
                    break;
                }

                num /= 10;
            }
        } 

        System.out.print(res);
    }

    static void check() {
        boolean[] chk = new boolean[B+1];

        int std = (int) Math.sqrt(B);

        int v;
        for (int i = 3; i <= std; i+= 2) {
            if (chk[i]) continue;

            v = i * i;
            while (v <= B) {
                chk[v] = true;
                v += i;
            }
        }

        if (A <= 2) list.add(2);
        A = Math.max(A, 3);
        if ((A & 1) == 0) A++;
        for (int i = A; i<= B; i += 2) {
            if (!chk[i]) list.add(i);
        }
    }

}
