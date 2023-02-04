package animeCup;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int a = s.length();
        int b = a - s.replace(":", "").length();
        int c = a - s.replace("_", "").length();

        System.out.println(a + b + c * 5); 
    }
}
