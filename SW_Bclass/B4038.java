package SW_Bclass;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class B4038 {
    static long P = 31;
    static long M = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String B = br.readLine();
            String S = br.readLine();

            int res = countOccurrences(B, S);
            sb.append("#" + t + " ").append(res + "\n");
        }

        System.out.print(sb.toString());
    }
    
    static int countOccurrences(String B, String S) {
        long sHash = 0;
        long bHash = 0;
        long power = 1;
        int count = 0;
        int sLength = S.length();

        for (int i = 0; i < sLength; i++) {
            sHash = (sHash + (S.charAt(i) - 'a' + 1) * power) % M;
            bHash = (bHash + (B.charAt(i) - 'a' + 1) * power) % M;

            if (i != sLength - 1) {
                power = (power * P) % M;
            }
        }

        long maxPower = power;

        for (int i = 0; i <= B.length() - sLength; i++) {
            if (sHash == bHash) {
                boolean found = true;
                for (int j = 0; j < sLength; j++) {
                    if (S.charAt(j) != B.charAt(i + j)) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    count++;
                }
            }

            if (i < B.length() - sLength) {
                bHash = ((P * (bHash - (B.charAt(i) - 'a' + 1) * maxPower % M + M)) % M + B.charAt(i + sLength) - 'a' + 1) % M;
            }
        }
        return count;
    }
}
