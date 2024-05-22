package GameTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_9659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        
        if (N % 2 == 0) {
            System.out.print("CY");
        } else {
            System.out.print("SK");
        }
    }
}
