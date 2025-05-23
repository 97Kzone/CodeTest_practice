package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class S2_12873 {

    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        long cnt = 1;
        int idx = 0;

        long tmp;
        while(list.size() != 1) {
            tmp = (long) Math.pow(cnt, 3);
            idx = (int) ((idx + tmp - 1) % list.size());
            list.remove(idx);
            cnt++;
        }

        System.out.print(list.peek());
    }
}
