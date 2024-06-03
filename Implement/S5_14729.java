package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class S5_14729 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        ArrayList<Double> list = new ArrayList<>();

        Double num;

        for (int i = 0; i < 7; i++) {
            num = Double.parseDouble(br.readLine());
            list.add(num);
        }
        Collections.sort(list);

        for (int i = 0; i < N - 7; i++) {
            num = Double.parseDouble(br.readLine());
            list.add(num);
            Collections.sort(list);

            list.remove(7);
        }

        for (int i = 0; i < 7; i++) {
            System.out.printf("%.3f", list.get(i));
            System.out.println();
        }
    }
}
