package Implement;

import java.util.ArrayList;
import java.util.Scanner;

public class S5_24039 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int result = 0;
        int i, j;
        
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (i = 2; i <= 10000; i++) {
			for (j = 2; j < i; j++) {
				if (i % j == 0) {
					break;
				}
			}

			if (i == j) {
				list.add(i);
			}
		}

		for (i = 0; i < list.size(); i++) {
			result = list.get(i) * list.get(i + 1);
			if (result > N) {
				System.out.println(result);
				System.exit(0);
			}
		}
    }
}
