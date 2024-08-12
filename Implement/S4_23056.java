package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S4_23056 {

    static class Student implements Comparable<Student>{
        int idx;
        String name;

        Student(int idx, String name) {
            this.idx = idx;
            this.name = name;
        }

        @Override
        public int compareTo(Student o) {
            if (this.idx == o.idx) {
                if (this.name.length() != o.name.length()) {
                    return this.name.length() - o.name.length(); 
                } else {
                    return this.name.compareTo(o.name); 
                }
            } else {
                return this.idx - o.idx; 
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Student> blue = new PriorityQueue<>();
        PriorityQueue<Student> white = new PriorityQueue<>();

        int[] bnum = new int[N + 1];
        int[] wnum = new int[N + 1];

        int a;
        String b;
        while (true) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = st.nextToken();
            if (a == 0) {
                break;
            }

            if (a % 2 == 0) {
                if (wnum[a] < M) {
                    wnum[a]++;
                    white.offer(new Student(a, b));
                }
            } else if (a % 2 == 1) {
                if (bnum[a] < M) {
                    bnum[a]++;
                    blue.offer(new Student(a, b));
                }
            } 
        }
        
        Student now;
        while (!blue.isEmpty()) {
            now = blue.poll();
            sb.append(now.idx + " ").append(now.name).append("\n");
        }

        while (!white.isEmpty()) {
            now = white.poll();
            sb.append(now.idx + " " + now.name).append("\n");
        }

        System.out.print(sb);
    }
}
