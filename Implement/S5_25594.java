package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class S5_25594 {

    static Map<Character, String> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();

        init();

        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < s.length()) {
            char firstChar = s.charAt(i);
            String mappedStr = map.get(firstChar);

            if (mappedStr == null || i + mappedStr.length() > s.length() || 
                !s.startsWith(mappedStr, i)) {
                sb.append("ERROR!");
                break;
            }

            result.append(firstChar);
            i += mappedStr.length();
        }

        if (sb.length() == 0) {
            sb.append("It's HG!\n").append(result);
        }

        System.out.println(sb.toString());
    }

    static void init() {
        map = new HashMap<>();

        map.put('a', "aespa");
        map.put('b', "baekjoon");
        map.put('c', "cau");
        map.put('d', "debug");
        map.put('e', "edge");
        map.put('f', "firefox");
        map.put('g', "golang");
        map.put('h', "haegang");
        map.put('i', "iu");
        map.put('j', "java");
        map.put('k', "kotlin");
        map.put('l', "lol");
        map.put('m', "mips");
        map.put('n', "null");
        map.put('o', "os");
        map.put('p', "python");
        map.put('q', "query");
        map.put('r', "roka");
        map.put('s', "solvedac");
        map.put('t', "tod");
        map.put('u', "unix");
        map.put('v', "virus");
        map.put('w', "whale");
        map.put('x', "xcode");
        map.put('y', "yahoo");
        map.put('z', "zebra");
    }
}
