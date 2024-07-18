package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class S5_17176 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Map<Character, Integer> map = initMap();

        int[] secretText = new int[N]; 
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            secretText[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(secretText); 

        String plainText = br.readLine(); 
        int[] arr = new int[plainText.length()];
        for (int i = 0; i < plainText.length(); i++) {
            arr[i] = map.get(plainText.charAt(i));
        }
        Arrays.sort(arr);

        System.out.print(Arrays.equals(secretText, arr) ? "y" : "n");
    }

    private static Map<Character, Integer> initMap() {
        Map<Character, Integer> map = new HashMap<>();
        map.put(' ', 0);
        for (char c = 'A'; c <= 'Z'; c++) {
            map.put(c, c - 64);
        }
        for (char c = 'a'; c <= 'z'; c++) {
            map.put(c, c - 70);
        }
        return map;
    }
}
