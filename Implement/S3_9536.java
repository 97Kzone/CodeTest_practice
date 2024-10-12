package Implement;

import java.util.*;
import java.io.*;

public class S3_9536 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        String std;
        String[] s;

        List<String> words;
        for (int t = 0; t < T; t++) {
            std = br.readLine();
            words = new ArrayList<>(Arrays.asList(std.split(" ")));

            while (true) {
                s = br.readLine().split(" ");
                if (s.length > 3)
                    break;
                
                String tmp = s[2];
                words.removeIf(word -> word.equals(tmp));
            }
            sb.append(String.join(" ", words) + "\n");
        }
        
        System.out.print(sb);
    }
}
