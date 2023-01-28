import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class D3_1225 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Queue<Integer> q;
        for (int t = 1; t <= 10; t++) {
            int tmp = sc.nextInt();
            q = new LinkedList<>();

            for (int i = 0; i < 8; i++) {
                q.add(sc.nextInt());
            }

            int v;
            loop:
            while (true) {
                for (int i = 1; i < 6; i++) {
                    v = q.poll();
                    if (v <= i) {
                        q.add(0);
                        break loop;
                    }
                    q.add(v-i);
                }
            }

            System.out.printf("#%d ", t);
            for (int i = 0; i< 8; i++) {
                System.out.print(q.poll() + " ");
            }
            System.out.println();
        }
    }
}
