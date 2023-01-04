package Java;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class impl_4158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int i=0; i<N; i++) {
            set.add(sc.nextInt());
        }

        for (int i=0; i<M; i++) {
            int tmp = sc.nextInt();
            if (set.contains(tmp)) {
                res += 1;
            }
        }

        N = sc.nextInt();
        M = sc.nextInt();
        System.out.print(res);
    }
}
