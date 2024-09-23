package Adhoc;

import java.io.*;
import java.util.*;

public class S5_31780 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        System.out.println(X * (M+1));
    }
}
