package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class S3_8911 {

    static int[][] moves = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 위, 오, 아래, 왼
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int maxX, maxY, minX, minY;
        int x, y, d;
        char[] lists;
        for (int t = 0; t < T; t++) {
            x = 0;
            y = 0;
            d = 0;

            maxX = 0;
            maxY = 0;
            minX = 0;
            minY = 0;

            lists = br.readLine().toCharArray();
            for (char cmd : lists) {
                if ('F' == cmd || 'B' == cmd) {
                    x += 'F' == cmd ? moves[d][0] : -moves[d][0];
                    y += 'F' == cmd ? moves[d][1] : -moves[d][1];

                    maxX = Math.max(maxX, x);
                    maxY = Math.max(maxY, y);
                    minX = Math.min(minX, x);
                    minY = Math.min(minY, y);
                } else if ('L' == cmd) {
                    d = d == 0 ? 3 : d - 1;
                } else if ('R' == cmd) {
                    d = d == 3 ? 0 : d + 1;
                }
            }
            int res = (maxX - minX) * (maxY - minY);

            bw.write(res + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}

