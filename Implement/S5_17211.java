package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_17211 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int flag = Integer.parseInt(st.nextToken());

        double[] score = new double[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            score[i] = Double.parseDouble(st.nextToken());
        }

        double good = 0.0;
        double bad = 0.0;

        if (N == 0)
            good = 1.0;
        else
            bad = 1.0;
        
        double gg = score[0];
        double gb = score[1];
        double bg = score[2];
        double bb = score[3];

        double std;
        for (int i = 0; i < N; i++) {
            std = good;
            good = good * gg + bad * bg;
            bad = std * gb + bad * bb;
        }

        System.out.println((int) (good * 1000));
        System.out.print((int) (bad * 1000));
    }
}
