package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class S5_31799 {

    static int N;
    static Stack<String> stk;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        String word = br.readLine().replace("0", "");
        int l = word.length();

        stk = new Stack<>();
        for (int i = 0; i < l; i++) {
            if (i + 1 < l && (Character.isLetter(word.charAt(i)) &&
                             !Character.isLetter(word.charAt(i + 1)))) {
                check(word.charAt(i) + String.valueOf(word.charAt(i + 1)));
                i++;
            } else if (Character.isLetter(word.charAt(i))) {
                check(String.valueOf(word.charAt(i)));
            }
        }        

        bw.flush();
        bw.close();
    }

    static void check(String s) throws IOException {
        if (s.contains("C")) {
            bw.write("B");
        } 
        else if ("B".equals(s) || "B-".equals(s)) {
            if (stk.isEmpty() || stk.peek().contains("C")) {
                bw.write("D");
            }
            else {
                bw.write("B");
            }
        } 
        else if ("A-".equals(s) || "B+".equals(s)) {
            if (stk.isEmpty() || stk.peek().contains("C") ||
                "B".equals(stk.peek()) || "B-".equals(stk.peek())) {
                bw.write("P");
            }
            else {
                bw.write("D");
            }
        } 
        else if ("A".equals(s)) {
            if (stk.isEmpty() || stk.peek().contains("C") ||
                "B".equals(stk.peek()) || "B-".equals(stk.peek()) || 
                "A-".equals(stk.peek()) || "B+".equals(stk.peek())) {
                bw.write("E");
            }
            else {
                bw.write("P");
            }
        } 
        else if ("A+".equals(s)) {
            bw.write("E");
        }

        stk.push(s);
    }
}