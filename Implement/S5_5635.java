package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class S5_5635 {

    static class Person implements Comparable<Person> {
        String name;
        int y;
        int m;
        int d;

        Person(String name, int y, int m, int d) {
            this.name = name;
            this.y = y;
            this.m = m;
            this.d = d;
        }

        @Override
        public int compareTo(Person o) {
            if (this.y == o.y) {
                if (this.m == o.m) {
                    return Integer.compare(this.d, o.d);
                }
                return Integer.compare(this.m, o.m);
            }

            return Integer.compare(this.y, o.y);
        }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<Person> list = new ArrayList<>();
        
        int N = Integer.parseInt(br.readLine());


        String name;
        int y, m, d;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            name = st.nextToken();
            d = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            list.add(new Person(name, y, m, d));
        }

        Collections.sort(list);
        System.out.println(list.get(N-1).name);
        System.out.print(list.get(0).name);
    }
}
