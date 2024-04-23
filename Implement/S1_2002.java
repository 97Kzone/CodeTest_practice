package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class S1_2002 {

    static int N;
    static int[] nums;
    static HashMap<String, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        nums = new int[N];
        
        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), i);
        }

        for (int i = 0; i < N; i++) {
            nums[i] = map.get(br.readLine());
        }

        int res = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (nums[i] > nums[j]) {
                    res++;
                    break;
                }
            }
        }

        System.out.print(res);
    }
    
}
