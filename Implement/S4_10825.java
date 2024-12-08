package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class S4_10825 {

    static class Student {
        String name;
        int s1;
        int s2;
        int s3;

        public Student(String name, int s1, int s2, int s3) {
            this.name = name;
            this.s1 = s1;
            this.s2 = s2;
            this.s3 = s3;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        ArrayList<Student> list = new ArrayList<>();

        String n;
        int s1, s2, s3;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            n = st.nextToken();
            s1 = Integer.parseInt(st.nextToken());
            s2 = Integer.parseInt(st.nextToken());
            s3 = Integer.parseInt(st.nextToken());

            list.add(new Student(n, s1, s2, s3));
        }

        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.s1 == o2.s1) {
                    if (o1.s2 == o2.s2) {
                        if (o1.s3 == o2.s3) {
                            return o1.name.compareTo(o2.name);
                        }
                        return o2.s3 - o1.s3;
                    }
                    return o1.s2 - o2.s2;
                }
                return o2.s1 - o1.s1;
            }
        });

        for (Student s : list) {
            sb.append(s.name).append("\n");
        }

        System.out.print(sb);
    }

}

