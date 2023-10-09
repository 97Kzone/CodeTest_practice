package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class S1_25542 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] parts = br.readLine().split(" ");
        int storeNumber = Integer.parseInt(parts[0]);
        int nameLength = Integer.parseInt(parts[1]);

        boolean firstChecker = true;
        String targetName = "";
        List<String> nameList = new ArrayList<>();

        for (int i = 0; i < storeNumber; i++) {
            String eachName = br.readLine().trim();

            if (firstChecker) {
                targetName = eachName;
                firstChecker = false;
            } else {
                nameList.add(eachName);
            }
        }

        Set<String> resultSet = new HashSet<>();

        for (int idx = 0; idx < nameLength; idx++) {
            for (int alpha = 65; alpha <= 90; alpha++) {
                char[] temp = targetName.toCharArray();
                temp[idx] = (char) alpha;
                resultSet.add(new String(temp));
            }
        }

        while (!resultSet.isEmpty() && !nameList.isEmpty()) {
            String nowCheckName = nameList.remove(nameList.size() - 1);
            Set<String> removeTarget = new HashSet<>();

            for (String eachResult : resultSet) {
                if (!isSimilar(nowCheckName, eachResult)) {
                    removeTarget.add(eachResult);
                }
            }

            for (String eachTarget : removeTarget) {
                resultSet.remove(eachTarget);
            }
        }

        if (resultSet.isEmpty()) {
            System.out.println("CALL FRIEND");
        } else {
            System.out.println(resultSet.iterator().next());
        }
    }

    public static boolean isSimilar(String checker, String target) {
        int length = checker.length();
        int counter = 0;

        for (int idx = 0; idx < length; idx++) {
            if (checker.charAt(idx) != target.charAt(idx)) {
                counter++;
            }
        }

        return counter <= 1;
    }
}
