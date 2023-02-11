package Bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.StringTokenizer;

public class G4_13701 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        BitSet bs = new BitSet();
        int tmp = 0;

        while (st.hasMoreTokens()) {
            tmp = Integer.parseInt(st.nextToken());
            
            if (bs.get(tmp)) continue; // 이미 있으면 pass

            bs.set(tmp);
            sb.append(tmp + " ");
        }
        System.out.println(sb.toString());
    }
}
