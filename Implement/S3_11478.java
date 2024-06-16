package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class S3_11478 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        Set<String> set = new HashSet<>();

        int N = s.length();
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j + i <= N; j++) {
                set.add(s.substring(j, j + i));
            }
        }

        System.out.print(set.size());
    }
}
