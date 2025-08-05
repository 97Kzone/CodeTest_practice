package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S4_15426 {

    static int tx, ty, n;
    static int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; //위 오른 아래 왼
    static String[] pass = {"Forward", "Right", "Left"};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        tx = Integer.parseInt(st.nextToken());
        ty = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(br.readLine());

        String cmd[] = new String[n];

        for (int i = 0; i < n; i++) {            
            cmd[i] = br.readLine();
        }

        String tmp;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (String s : pass) {
                if (cmd[i].equals(s)) continue;

                tmp = cmd[i];
                cmd[i] = s;

                if (check(cmd)) {
                    bw.write((i+1) + " " + s);
                    flag = true;
                    break;                    
                }

                cmd[i] = tmp;
            }
            if (flag) break;
        }
        
        bw.flush();
        bw.close();
    }

    static boolean check(String[] cmds) {
        int x = 0;
        int y = 0;
        int d = 0;

        for (String cmd : cmds) {
            if ("Forward".equals(cmd)) {
                x += moves[d][0];
                y += moves[d][1];
            } else if ("Right".equals(cmd)) {
                d = (d + 1) % 4;
            } else if ("Left".equals(cmd)) {
                d = (d + 3) % 4;
            }
        }

        return tx == x && ty == y;
    }
}
