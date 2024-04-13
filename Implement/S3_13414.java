package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class S3_13414 {

    static int K, L;
    static LinkedHashSet<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        K = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        set = new LinkedHashSet<>();

        String id;
        for (int i = 0; i < L; i++) {
            id = br.readLine();

            if (set.contains(id)) set.remove(id);
            set.add(id);
        }

        int idx = 0;
        for (String s : set) {
            sb.append(s + "\n");
            if (++idx == K) break;
        }
        
        System.out.print(sb); 
    }
}
