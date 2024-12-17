package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class S5_31216 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> arr=new ArrayList<>();
        int[] num=new int[318138];
        num[1] = 1;
        
        for(int i = 2; i < 318138; i++){
            if (num[i] == 1)
                continue;

            for(int j = i + i; j < 318138; j += i){
                num[j] = 1;
            }
        }

        int k=1;
        for(int i = 2; i < 318138; i++){
            if (num[i] != 0)
                continue;
            if(num[k]==0) {
                arr.add(i);
            }
            k++;
        }

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(arr.get(n - 1) + "\n");
        }
        
        System.out.print(sb);
    }
}
