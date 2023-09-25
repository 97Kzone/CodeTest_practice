package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_14655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int[] arr1 = new int[N];
        int[] arr2 = new int[N];
        int result = 0;

        for (int i = 0; i < N; i++) {
            arr1[i] = Math.abs(Integer.parseInt(st1.nextToken()));
            arr2[i] = Math.abs(Integer.parseInt(st2.nextToken()));

            result += arr1[i] + arr2[i];
        }
        System.out.println(result);
    }

}