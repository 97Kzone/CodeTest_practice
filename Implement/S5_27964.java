package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class S5_27964 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int N = Integer.parseInt(br.readLine());
        String[] words = br.readLine().split(" ");
        HashSet<String> set = new HashSet<>();

        for (String word : words) {
            if (word.endsWith("Cheese")) {
                set.add(word);
            }
        }

        System.out.print(set.size() >= 4 ? "yummy" : "sad");
    }
}
