package Implement;

import java.io.*;
import java.util.*;

public class S3_31672 {

    static int N;
    static List<int[][]> data = new ArrayList<>();
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        br.readLine();
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int[][] student = new int[3][];
            
            st = new StringTokenizer(br.readLine());
            student[0] = new int[]{Integer.parseInt(st.nextToken())};  
            
            st = new StringTokenizer(br.readLine());
            int M = student[0][0];
            student[1] = new int[M];  
            for (int j = 0; j < M; j++) {
                student[1][j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            student[2] = new int[]{Integer.parseInt(st.nextToken())};  

            data.add(student);
        }

        for (int i = 0; i < N; i++) {
            Set<Integer> check = new HashSet<>();
            for (int j = 1; j <= N; j++) check.add(j);

            for (int j = 0; j < N; j++) {
                int M = data.get(j)[0][0];
                Set<Integer> S = new HashSet<>();
                for (int v : data.get(j)[1]) S.add(v);
                int B = data.get(j)[2][0];

                if (i == j) {
                    B ^= 1;
                }

                if (B == 1) {
                    check.retainAll(S);
                } else {
                    check.removeAll(S);
                }
            }

            if (check.contains(i + 1)) {
                answer.add(i + 1);
            }
        }

        if (answer.isEmpty()) {
            bw.write("swi");
        } else {
            for (int v : answer) {
                bw.write(v + " ");
            }
        }

        bw.flush();
        bw.close();
    }
}
