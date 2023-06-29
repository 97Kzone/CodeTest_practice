package Implement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class S3_7696 {
    
    static int N;
    static List<Integer> nums;
    static Set<Integer> use = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        init();

        int n;
        while (true) {
            n = sc.nextInt();
            if (n == 0)
                break;

            sb.append(n + "\n");    
        }
        System.out.print(sb.toString());
    }
    
    static void init() {
        nums = new ArrayList<>();
        int num = 1;

        while (nums.size() < 1000001) {
            if (check(num))
                nums.add(num++);
        }
    }

    static boolean check(int n) {
        use.clear();
        
        int v;
        while (n > 0) {
            v = n % 10;

            if (use.contains(v))
                return false;
            use.add(v);
            n /= 10;
        }

        return true;
    }
}
