package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G4_13019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String A = br.readLine();
        String B = br.readLine();

        int L = A.length() - 1;
        int cnt = 0;
        for (int i = L; i >= 0; i--) {
            if (B.charAt(L) == A.charAt(i)) {
                L--;
            } else {
                cnt++;
            }
        }

        String[] sortA = A.split("");
        String[] sortB = B.split("");

        Arrays.sort(sortA);
        Arrays.sort(sortB);
        
        boolean flag = true;
        for (int i = 0; i < A.length(); i++) {
            if (sortA[i].equals(sortB[i])) continue;
            flag = false;
            break;
        }

        System.out.print(flag ? cnt : -1);        
    }
}
