import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        if (K < N + M - 1) System.out.println("NO");
        else {
            int v = 1;
            System.out.println("YES");
            for (int i = 0; i < N; i++) {
                int v2 = v;
                for (int j = 0; j < M; j++) {
                    sb.append(v2++ + " ");
                }
                v++;
                sb.append("\n");
            }
            System.out.print(sb.toString());
        }
    }
}
