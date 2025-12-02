package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class S4_15233 {

    static int A, B, G;
    static Set<String> setA, setB;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());

        setA = new HashSet<>();
        setB = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            setA.add(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            setB.add(st.nextToken());
        }

        int cntA = 0;
        int cntB = 0;
        String name;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < G; i++) {
            name = st.nextToken();
            if (setA.contains(name)) cntA++;
            else cntB++;
        }

        if (cntA == cntB) System.out.println("TIE");
        else if (cntA > cntB) System.out.println("A");
        else if (cntA < cntB) System.out.println("B");
    }
}
