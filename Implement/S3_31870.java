package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_31870 {

    static int N;
    static int[] nums1, nums2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums1 = new int[N];
        nums2 = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums1[i] = Integer.parseInt(st.nextToken());
            nums2[i] = nums1[i];
        }
        
        int v1 = check1();
        int v2 = check2();

        int res = Math.min(v1, v2);
        System.out.print(res);
    }

    static int check1() {
        int res = 0;

        int tmp;
        boolean flag;
        while(true) {

            flag = false;
            for (int i = 0; i < N-1; i++) {
                if (nums1[i] > nums1[i + 1]) {
                    tmp = nums1[i];
                    nums1[i] = nums1[i + 1];
                    nums1[i + 1] = tmp;
                    
                    res++;
                    flag = true;
                }
            }

            if (!flag) break;
        }

        return res;
    }

    static int check2() {
        int res = 0;

        int tmp;
        boolean flag;
        while(true) {

            flag = false;
            for (int i = 0; i < N-1; i++) {
                if (nums2[i] < nums2[i + 1]) {
                    tmp = nums2[i];
                    nums2[i] = nums2[i + 1];
                    nums2[i + 1] = tmp;
                    
                    res++;
                    flag = true;
                }
            }

            if (!flag) break;
        }

        return res + 1;
    }
}