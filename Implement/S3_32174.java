package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S3_32174 {
    
    static int N, M;
    static List<Long> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        list.add(1L);

        long a, b;
        long std;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            a = Long.parseLong(st.nextToken());
            b = Long.parseLong(st.nextToken());
            std = list.get(list.size() - 1);

            if (a == 1) {
                list.add(check(std + b));
            } else if (a == 2) {
                list.add(check(std - b));
            } else if (a == 3) {
                list.add(list.get((int)b));
            }
        }
        
        System.out.println(list.get(list.size() - 1));

    }

        static long check(long v) {
        return ((v - 1) % N + N) % N + 1;
    }
}
