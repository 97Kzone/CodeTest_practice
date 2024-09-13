package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class S4_11507 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Set<String> setP = new HashSet<>();
        Set<String> setK = new HashSet<>();
        Set<String> setH = new HashSet<>();
        Set<String> setT = new HashSet<>();

        String s = br.readLine();
        String tmp;

        char c;
        String num;
        for (int i = 0; i <= s.length() - 3; i += 3) {
            tmp = s.substring(i, i + 3);

            c = tmp.charAt(0);
            num = tmp.substring(1, 3);

            if (c == 'P') {
                if (setP.contains(num)) {
                    System.out.print("GRESKA");
                    return;
                }

                setP.add(num);
            } else if (c == 'K') {
                if (setK.contains(num)) {
                    System.out.print("GRESKA");
                    return;
                }

                setK.add(num);
            } else if (c == 'H') {
                if (setH.contains(num)) {
                    System.out.print("GRESKA");
                    return;
                }

                setH.add(num);
            } else if (c == 'T') {
                if (setT.contains(num)) {
                    System.out.print("GRESKA");
                    return;
                }

                setT.add(num);
            }
        }
        
        sb.append((13 - setP.size()) + " ");
        sb.append((13 - setK.size()) + " ");
        sb.append((13 - setH.size()) + " ");
        sb.append((13 - setT.size()) + " ");
        
        System.out.print(sb);
    }
}
