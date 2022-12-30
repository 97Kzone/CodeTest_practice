import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D1_2059 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();

        int res = 0;
        for (int i = 0; i<num.length(); i++) {
            res += Integer.parseInt(num.substring(i, i+1));
        }
        System.out.println(res);
    }
}