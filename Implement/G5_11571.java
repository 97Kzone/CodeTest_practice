package Implement;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class G5_11571 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int q = a / b;  // 몫
            int r = a % b;  // 나머지
            StringBuilder sb = new StringBuilder();
            Map<Integer, Integer> map = new HashMap<>();
            while (true) {
                if (map.containsKey(r)) {
                    sb.insert(map.get(r), "(");
                    sb.append(")");
                    break;
                }
                map.put(r, sb.length());
                r *= 10;
                sb.append(r / b);
                r %= b;
            }
            System.out.println(q + "." + sb.toString());
        }
        sc.close();
    }
}
