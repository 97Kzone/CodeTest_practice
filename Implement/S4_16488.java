package Implement;

import java.util.*;
import java.io.*;

public class S4_16488 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        long res = N * N * K;
        System.out.print(res);
    }
}
