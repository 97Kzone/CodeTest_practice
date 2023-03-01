import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SW_4013 {
    static int K, res;
    static ArrayList<Integer>[] wheel;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            K = Integer.parseInt(br.readLine());

            wheel = new ArrayList[5];
            for (int i = 1; i < 5; i++) wheel[i] = new ArrayList<>();


            // 번호 별 톱니 상태
            for (int i = 1; i < 5; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 8; j++) {
                    wheel[i].add(Integer.parseInt(st.nextToken()));
                }
            }

            int idx, d;
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                idx = Integer.parseInt(st.nextToken());
                d = Integer.parseInt(st.nextToken());
                
                check(idx, d);
                for (int j = 1; j < 5; j++) {
                    System.out.println(wheel[j].toString());
                }
            }

            res = 0;
            for (int i = 1; i < 4; i++) {
                res += wheel[i].get(0) * Math.pow(2, i);
            }
            sb.append("#" + t + " ").append(res + "\n");
        }
        System.out.print(sb.toString());
    }

    // 해당 톱니 돌리기
    static void check(int idx, int d) {
        if (idx == 1) isRight(idx, d);
        else if (idx == 2) {
            isLeft(idx, d);
            isRight(idx, d);
        } else if (idx == 3) {
            isLeft(idx, d);
            isRight(idx, d);
        } else isLeft(idx, d);
    }
    
    static void isLeft(int idx, int d) {
        int std = wheel[idx].get(6) ^ wheel[idx-1].get(2);
        if (std == 1) {
            if (d == 1) {
                rotate(idx);
                rotate2(idx-1);
            } else {
                rotate2(idx);
                rotate(idx-1);
            }
        } else {
            if (d == 1) rotate(idx);
            else rotate2(idx);
        }
    }

    static void isRight(int idx, int d) {
        int std = wheel[idx].get(2) ^ wheel[idx+1].get(6);
        if (std == 1) {
            if (d == 1) { 
                rotate(idx);
                rotate2(idx+1);
            } else { 
                rotate2(idx);
                rotate(idx+1);
            }
        } else {
            if (d == 1) rotate(idx);
            else rotate2(idx);
        }
    }

    // 시계방향 돌리기
    static void rotate(int idx) {
        wheel[idx].add(0, wheel[idx].remove(7));
    }

    // 반시계방향 돌리기
    static void rotate2(int idx) {
        wheel[idx].add(wheel[idx].remove(0));
    }
}
