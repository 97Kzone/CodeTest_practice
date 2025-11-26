package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class S3_9996 {

    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        String[] tmp = br.readLine().split("\\*");

        String start = tmp[0];
        String end = tmp[1];

        String std;
        for (int i = 0; i < N; i++) {
            std = br.readLine();

            boolean flag = true;
            if (std.startsWith(start)) std = std.replaceFirst(start, "");
            else flag = false;

            if (!std.endsWith(end)) flag = false;


            
            bw.write(flag ? "DA" : "NE");
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
