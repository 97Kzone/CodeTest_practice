package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S5_11575 {

    static int A, B, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());

        int num;
        int std = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = M; i > 0; i--) {
            num = Integer.parseInt(st.nextToken());
            std += num * Math.pow(A, i - 1);
        }

        if (std == 0) {
            bw.write("0");
        }

        List<Integer> list = new ArrayList<>();
        while(std != 0) {
            list.add(std % B);
            std /= B;
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            bw.write(list.get(i) + " ");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
