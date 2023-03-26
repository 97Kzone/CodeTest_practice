package UDP_2023;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class C {
    static Deque<Integer> nums;
    static int[] idx;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();

        nums = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (i % 2 != 0) {
                nums.offerFirst(i);
            } else {
                nums.offerLast(i);
            }
        }

        idx = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int num = nums.pollFirst();
            idx[num] = i;
            sb.append(num + " ");
        }
        sb.append("\n");
        for (int i = 1; i <= N; i++) {
            sb.append(idx[i] + " ");
        }
        System.out.println("YES");
        System.out.print(sb.toString());
    }
}
