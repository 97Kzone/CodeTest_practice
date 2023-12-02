package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class S1_25215 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        boolean isFirstCap = Character.isUpperCase(input.charAt(0));
        boolean isCapsLock = false;
        boolean isUpper = isFirstCap;

        List<Integer> v = new ArrayList<>();
        int total = 0;

        int cnt = 0;
        for (int i = 0; i < input.length(); i++) {
            if (isUpper && Character.isUpperCase(input.charAt(i))) {
                cnt++;
                total++;
            } else if (isUpper && !Character.isUpperCase(input.charAt(i))) {
                v.add(cnt);
                cnt = 1;
                isUpper = false;
                total++;
            } else if (!isUpper && Character.isUpperCase(input.charAt(i))) {
                v.add(cnt);
                cnt = 1;
                isUpper = true;
                total++;
            } else if (!isUpper && !Character.isUpperCase(input.charAt(i))) {
                cnt++;
                total++;
            }
        }
        v.add(cnt);

        if (isFirstCap) {
            for (int j = 0; j < v.size(); j++) {
                if (isCapsLock && j % 2 == 1) {
                    if (v.get(j) == 1)
                        total++;
                    else if (v.get(j) > 1) {
                        isCapsLock = false;
                        total++;
                    }
                } else if (!isCapsLock && j % 2 == 0) {
                    if (v.get(j) == 1)
                        total++;
                    else if (v.get(j) > 1) {
                        isCapsLock = true;
                        total++;
                    }
                }
            }
        } else {
            for (int j = 0; j < v.size(); j++) {
                if (isCapsLock && j % 2 == 0) {
                    if (v.get(j) == 1)
                        total++;
                    else if (v.get(j) > 1) {
                        isCapsLock = false;
                        total++;
                    }
                } else if (!isCapsLock && j % 2 == 1) {
                    if (v.get(j) == 1)
                        total++;
                    else if (v.get(j) > 1) {
                        isCapsLock = true;
                        total++;
                    }
                }
            }
        }
        System.out.print(total);
    }
}
