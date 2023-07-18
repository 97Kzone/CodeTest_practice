package PG_Level1;

class Solution {

    static int h, w, mx, my, Mx, My;
    static String[][] board;

    public int[] solution(String[] wallpaper) {
        h = wallpaper.length;
        w = wallpaper[0].length();
        board = new String[h][w];

        mx = h;
        my = w;
        Mx = 0;
        My = 0;

        for (int i = 0; i < h; i++) {
            board[i] = wallpaper[i].split("");
            for (int j = 0; j < w; j++) {
                if ("#".equals(board[i][j])) {
                    mx = Math.min(mx, i);
                    Mx = Math.max(Mx, i);
                    my = Math.min(my, j);
                    My = Math.max(My, j);
                }
            }
        }

        return new int[] {mx, my, Mx + 1, My + 1};
    }
}