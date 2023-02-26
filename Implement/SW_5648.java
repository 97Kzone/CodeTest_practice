package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SW_5648 {
    static int N, res;
    static int[][] board = new int[4002][4002]; // 좌표평면
    static boolean[][] isPop = new boolean[4002][4002]; // 충돌 플래그
    static int[][] moves = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}}; // 좌표평면에 맞춘 상하좌우
    static ArrayList<Node> nodes; // 원자 집합

    //원자 객체
    static class Node {
        int x;
        int y;
        int d;
        int v;

        Node (int x, int y, int d, int v) {
            this.x = x * 2;
            this.y = y * 2;
            this.d = d;
            this.v = v;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            nodes = new ArrayList<>();

            int x, y, d, v; 
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                d = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());

                nodes.add(new Node(x + 1000, y + 1000, d, v));
            }

            res = 0;
            check();
            sb.append("#" + t + " ").append(res + "\n");
        }
        System.out.print(sb.toString());
    }


    static void check() {
        int cnt = 0;

        // 현재 원자 상태 초기화
        for (int i = 0; i < nodes.size(); i++) {
            board[nodes.get(i).x][nodes.get(i).y]++;
        }

        // -2000 -> 2000 까지 이동 가능
        for (int i = 0; i < 4002; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                Node now = nodes.get(j);

                board[now.x][now.y]--; // 원래자리에서 탈출
                now.x += moves[now.d][0];
                now.y += moves[now.d][1];

                if (!isPossible(now.x, now.y)) {
                    nodes.remove(j--);
                }
                else {
                    board[now.x][now.y]++; // 이동자리로 도착
                    if (board[now.x][now.y] > 1) isPop[now.x][now.y] = true;
                }
            }

            for (int j = 0; j < nodes.size(); j++) {
                Node now = nodes.get(j);
  
                if (!isPop[now.x][now.y]) continue; // 충돌 안하면 PASS
                if (board[now.x][now.y] == 1) isPop[now.x][now.y] = false; // 다 처리했으니 플래그 내려
                board[now.x][now.y]--;
                cnt += now.v;
                nodes.remove(j--);
            }
            if (nodes.size() == 0) break;
        }
        res = Math.max(res, cnt);
    }

    static boolean isPossible(int x, int y) {
        return (0 <= x && x < 4001) && (0 <= y && y < 4001);
    }
}
