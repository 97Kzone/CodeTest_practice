package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S4_16499 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        String[] word;
        for (int i = 0; i < N; i++) {
            word = br.readLine().split("");
            Arrays.sort(word);

            sb = new StringBuilder();
            Arrays.stream(word).forEach(sb::append);

            set.add(sb.toString());
        }
        
        System.out.print(set.size());

        
    }
}
