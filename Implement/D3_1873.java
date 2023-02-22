package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class D3_1873 {
    static int H, W, N, x, y;
    static char[][] board;
    static Map<Character, int[]> aim;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        aim = new HashMap<Character, int[]>() {{
            put('<', new int[] {0, -1});
            put('^', new int[] {-1, 0});
            put('>', new int[] {0, 1});
            put('v', new int[] {1, 0});
        }};

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            
            board = new char[H][W];
            for (int i = 0; i < H; i++) {
                board[i] = br.readLine().toCharArray();
                for (int j = 0; j < W; j++) {
                    if (board[i][j] == '<' || board[i][j] == '^' ||
                        board[i][j] == '>' || board[i][j] == 'v') {
                        
                        x = i;
                        y = j;
                    } 
                }
            }
            
            N = Integer.parseInt(br.readLine());
            String s = br.readLine();

            for (int i = 0; i < N; i++) {
                char c = s.charAt(i);
                if (c == 'U') up();
                else if (c == 'D') down();
                else if (c == 'L') left();
                else if (c == 'R') right();
                else if (c == 'S') shot();
            }
            
            sb.append("#" + t + " ");
            for (char[] row : board) {
                for (char c : row) {
                    sb.append(c);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    static void up() {
        board[x][y] = '^';
        if (x >= 1 && board[x-1][y] == '.') {
            board[x--][y] = '.';
            board[x][y] = '^';
        }
    }

    static void down() {
        board[x][y] = 'v';
        if (x < H-1 && board[x+1][y] == '.') {
            board[x++][y] = '.';
            board[x][y] = 'v';
        }
    }

    static void left() {
        board[x][y] = '<';
        if (y >= 1 && board[x][y-1] == '.') {
            board[x][y--] = '.';
            board[x][y] = '<';
        }
    }
    
    static void right() {
        board[x][y] = '>';
        if (y < W - 1 && board[x][y+1] == '.') {
            board[x][y++] = '.';
            board[x][y] = '>';
        }
    }

    static void shot() {
        int dx = aim.get(board[x][y])[0];
        int dy = aim.get(board[x][y])[1];

        int nx = x, ny = y;
        while (true) {
            nx += dx;
            ny += dy;

            // 포탄이 맵 밖으로
            if (nx < 0 || ny < 0 || nx >= H || ny >= W) return;
            
            if (board[nx][ny] == '*') {
                board[nx][ny] = '.';
                return;
            } else if (board[nx][ny] == '#') return;
        }
    }
}