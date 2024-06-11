package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_14405 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        s = s.replaceAll("pi", " ");
        s = s.replaceAll("ka", " ");
        s = s.replaceAll("chu", " ");
        s = s.replaceAll(" ", "");
        
        System.out.print(s.length() == 0 ? "YES" : "NO");
    }
}
