package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_31263 {

    static int N;
    static char[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = br.readLine().toCharArray();

        int res = 0;
        int idx = 0;
        int tmp;
        while(idx < N) {
            if (N - idx <= 3) {
                tmp = Integer.parseInt(new String(list, idx, N - idx));
                if (tmp <= 641) {
                    res++;
                    break;
                } else {
                    idx += 2;
                    res++;
                }
            } else {
                if (list[idx + 2] == '0') {
                    if (list[idx + 3] == '0') {
                        idx++;
                        res++;
                    } else {
                        tmp = Integer.parseInt(new String(list, idx, 3));
                        if (tmp <= 641) {
                            idx += 3;
                            res++;
                        } else {
                            idx++;
                            res++;
                        }
                    }   
                } else {
                    if (list[idx + 3] == '0') {
                        idx += 2;
                        res++;
                    } else {
                        tmp = Integer.parseInt(new String(list, idx, 3));
                        if (tmp <= 641) {
                            idx += 3;
                            res++;
                        } else {
                            idx += 2;
                            res++;
                        }
                    }
                }
            }
        }
        System.out.print(res);
    }
}
