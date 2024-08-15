package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class S4_25329 {

    static class Student implements Comparable<Student>{
        String name;
        int time;

        Student(String name, int time) {
            this.name = name;
            this.time = time;
        }

        @Override
        public int compareTo(Student o) {
            if (this.time == o.time) {
                return this.name.compareTo(o.name);
            }
            return o.time - this.time;
        }

        
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        int time;
        String name;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            time = str2int(st.nextToken());
            name = st.nextToken();

            if (map.containsKey(name)) {
                map.put(name, map.get(name) + time);
            } else {
                map.put(name, time);
            }
        }

        List<Student> list = new ArrayList<>();
        for (String key : map.keySet()) {
            list.add(new Student(key, time2cost(map.get(key))));
        }

        Collections.sort(list);
        for (Student student : list) {
            sb.append(student.name + " " + student.time).append("\n");
        }

        System.out.print(sb);
    }

    static int str2int(String s) {
        String time[] = s.split(":");

        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }

    static int time2cost(int time) {
        if (time <= 100) {
            return 10;
        } else {
            time -= 100;
            if (time % 50 == 0) {
                return ((time / 50) * 3) + 10;
            } else {
                return (((time / 50) + 1) * 3) + 10;
            }
        }
    }
}
