package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class S4_1269 {

    static int A, B;
    static Set<Integer> setA, setB, std;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        setA = new HashSet<>();
        setB = new HashSet<>();
        std = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            setA.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            setB.add(Integer.parseInt(st.nextToken()));
        }

        for (int n : setA) {
            if (setB.contains(n)) {
                std.add(n);
            }
        }

        for (int n : setB) {
            if (setA.contains(n)) {
                std.add(n);
            }
        }

        System.out.print(setA.size() + setB.size() - (std.size() * 2));
    }
}
