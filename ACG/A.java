package ACG;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
    
        String res = N * 100 >= M ? "Yes" : "No";
        System.out.print(res);
    }
}
