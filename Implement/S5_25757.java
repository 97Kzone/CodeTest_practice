package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class S5_25757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        int players = 0;
        if (game.equals("Y"))
            players = 1;
        else if (game.equals("F"))
            players = 2;
        else if (game.equals("O"))
            players = 3;

        int count = 0;
        int playersTemp = players;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            if (set.contains(name))
                continue;
            else {
                set.add(name);
                playersTemp--;
                if (playersTemp == 0) {
                    count++;
                    playersTemp = players;
                }
            }
        }
        System.out.println(count);
    }
}
