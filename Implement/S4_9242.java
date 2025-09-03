package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S4_9242 {

    static String[][] patterns = {
        {"***", "* *", "* *", "* *", "***"},
        {"  *", "  *", "  *", "  *", "  *"},
        {"***", "  *", "***", "*  ", "***"},
        {"***", "  *", "***", "  *", "***"},
        {"* *", "* *", "***", "  *", "  *"},
        {"***", "*  ", "***", "  *", "***"},
        {"***", "*  ", "***", "* *", "***"},
        {"***", "  *", "  *", "  *", "  *"},
        {"***", "* *", "***", "* *", "***"},
        {"***", "* *", "***", "  *", "***"}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] lines = new String[5];
        for (int i = 0; i < 5; i++) {
            lines[i] = br.readLine();
        }

        int cnt = (lines[0].length() + 1) / 4;
        
        StringBuilder result = new StringBuilder();
        String[] std; 
        int s, e, num;
        for (int i = 0; i < cnt; i++) {
            std = new String[5];
            
            for (int row = 0; row < 5; row++) {
                s = i * 4;
                e = Math.min(s + 3, lines[row].length());
                std[row] = lines[row].substring(s, e);
            }

            num = check(std);
            if (num != -1) {
                result.append(num);
            }
        }
        int res = Integer.parseInt(result.toString());
        System.out.print(res % 6 == 0 ? "BEER!!" : "BOOM!!");
    }

    static int check(String[] pattern) {

        for (int i = 0; i < 10; i++) {
            boolean flag = true;
            for (int row = 0; row < 5; row++) {
                if (!pattern[row].equals(patterns[i][row])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1; 
    }
}
