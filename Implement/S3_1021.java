package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class S3_1021 {

    static int N, M, res;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> dq = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            dq.offer(i);
        }
        
        nums = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        res = 0;
        int idx, std;
        for (int i = 0; i < M; i++) {
            idx = dq.indexOf(nums[i]);
            std = dq.size() / 2;

            if (idx <= std) {
                while(dq.peek() != nums[i]) {
                    dq.offerLast(dq.pollFirst());
                    res++;
                }
            } else {
                while(dq.peek() != nums[i]) {
                    dq.offerFirst(dq.pollLast());
                    res++;
                }
            }
            dq.poll();
        }

        System.out.print(res);
    }
}
