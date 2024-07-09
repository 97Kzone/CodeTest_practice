package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class S3_29730 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> sol = new PriorityQueue<>();
        List<String> study = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        String s1, s2;        
        for (int i = 0; i < N; i++) {
            s1 = br.readLine();
            
            if (s1.contains("/")) {
                s2 = s1.split("/")[1];

                if (isNumeric(s2)) {
                    sol.offer(Integer.parseInt(s2));
                } else {
                    study.add(s1);
                }
            } else {
                study.add(s1);
            }
            
        }

        Collections.sort(study, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return Integer.compare(o1.length(), o2.length());
                }
            }
        });

        for (String st : study) {
            sb.append(st + "\n");
        }

        while (!sol.isEmpty()) {
            sb.append("boj.kr/" + sol.poll() + "\n");
        }

        System.out.print(sb);
    }

    public static boolean isNumeric(String str) {

        return str.matches("-?\\d+");
    }
}
