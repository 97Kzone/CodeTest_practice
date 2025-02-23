package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class S5_32979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            dq.offer(Integer.parseInt(st.nextToken()));
        }

        int[] nums = new int[T];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < T; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int idx;
        for (int i = 0; i < T; i++) {
            idx = 1;
            while(true) {
                if (idx == nums[i]) {
                    sb.append(dq.peek() + " ");
                    break;
                }

                dq.offerLast(dq.poll());
                idx++;
            }
        }
        System.out.print(sb.toString());
    }
}