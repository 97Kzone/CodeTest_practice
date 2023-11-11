package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_16888 {

    static int N, num;
    static boolean[] canWin; // 숫자별 승패여부 체크
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        canWin = new boolean[1000001];

        // 제곱수는 반드시 이긴다
        for (int i = 1; i <= 1000; i++) canWin[i * i] = true;

        // 내 차례에 해당 숫자가 오면 이기는가?
        for (int i = 2; i <= 1000000; i++) {
            
            // 이미 이긴 경우는 이긴거다 뭘 해도 이긴다.
            if(canWin[i]) continue;

            // 지는 경우라면 해당 수에 도달하는 모든 경우는 이긴다.
            for (int j = 1; j <= 1000; j++) {
                if (j * j + i > 1000000) break;
                canWin[j * j + i] = true;
            }
        }

        while (N-- > 0) {
            num = Integer.parseInt(br.readLine());

            if (canWin[num]) sb.append("koosaga" + "\n");
            else sb.append("cubelover" + "\n");
        }

        System.out.print(sb.toString());
    }
}
