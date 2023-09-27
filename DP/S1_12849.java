package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_12849 {
    static final int std = 1000000007;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[][] map = new long[N + 1][8];
        map[0][0] = 1;

        for (int i = 0; i < N; i++) {
            map[i + 1][0] = (map[i][1] + map[i][2]) % std;
            map[i + 1][1] = (map[i][0] + map[i][2] + map[i][3]) % std;
            map[i + 1][2] = (map[i][0] + map[i][1] + map[i][3] + map[i][5]) % std;
            map[i + 1][3] = (map[i][1] + map[i][2] + map[i][4] + map[i][5]) % std;
            map[i + 1][4] = (map[i][3] + map[i][5] + map[i][6]) % std;
            map[i + 1][5] = (map[i][2] + map[i][3] + map[i][4] + map[i][7]) % std;
            map[i + 1][6] = (map[i][4] + map[i][7]) % std;
            map[i + 1][7] = (map[i][5] + map[i][6]) % std;
        }

        System.out.println(map[N][0]);
    }

}
