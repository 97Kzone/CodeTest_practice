import java.util.*;

class Solution {
    static List<List<int[]>> blanks, blocks; // 빈 공간, 블록을 담을 리스트

    static Queue<int[]> q = new ArrayDeque();
    static int N, answer; // 보드 크기
    static int[][] moves = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    static int[][] gboard;

    public int solution(int[][] game_board, int[][] table) {
        answer = 0;

        blocks = new ArrayList<>();
        blanks = new ArrayList<>();

        N = game_board.length;

        // 블록, 빈 공간 추출하기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (table[i][j] == 1)
                    table = findBlock(i, j, table, 1);
                if (game_board[i][j] == 0)
                    game_board = findBlock(i, j, game_board, 0);
            }
        }

        // 빈 공간, 블록 사이즈 순 내림차 정렬
        blocks.sort((o1, o2) -> (o2.size() - o1.size()));
        blanks.sort((o1, o2) -> (o2.size() - o1.size()));

        // 블록 맞추기 놀이 시작
        check();

        return answer;
    }

    // 빈 공간과 블록의 크기가 같은지 확인
    static void check() {
        boolean[] use = new boolean[blanks.size()];
        List<int[]> blank;

        for (List<int[]> block : blocks) {
            for (int i = 0; i < blanks.size(); i++) {
                blank = blanks.get(i);
                if (block.size() == blank.size() && !use[i]) {
                    if (isMatch(block, blank)) {
                        answer += block.size();
                        use[i] = true;
                        break;
                    }
                }
            }
        }
    }

    // 빈 공간과 블럭의 좌표가 일치하는지 확인
    static boolean isMatch(List<int[]> block, List<int[]> blank) {
        boolean res = false;

        block.sort((o1, o2) -> {
            return o1[0] > o2[0] ? 1 : o1[0] < o2[0] ? -1 : Integer.compare(o1[1], o2[1]);
        });

        // 4가지 방향성 체크
        for (int i = 0; i < 4; i++) {
            blank.sort((o1, o2) -> {
                return o1[0] > o2[0] ? 1 : o1[0] < o2[0] ? -1 : Integer.compare(o1[1], o2[1]);
            });

            int dx = blank.get(0)[0];
            int dy = blank.get(0)[1];

            for (int j = 0; j < blank.size(); j++) {
                blank.get(j)[0] -= dx;
                blank.get(j)[1] -= dy;
            }

            boolean flag = true;
            for (int j = 0; j < block.size(); j++) {
                int[] blockXY = block.get(j);
                int[] blankXY = blank.get(j);

                if (blockXY[0] != blankXY[0] || blockXY[1] != blankXY[1]) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                res = true;
                break;
            } else
                blank = rotate(blank);
        }
        return res;
    }

    // 돌려 버리기
    static List<int[]> rotate(List<int[]> list) {
        List<int[]> res = new ArrayList<>();

        for (int[] now : list)
            res.add(new int[] { now[1], -now[0] });

        return res;
    }

    // 블록, 공간 찾기
    static int[][] findBlock(int a, int b, int[][] board, int std) {
        q.clear();
        List<int[]> res = new ArrayList<>(); // 합격한 좌표들 모음

        q.offer(new int[] { a, b });
        res.add(new int[] { 0, 0 });

        board[a][b] ^= 1;

        int nx, ny;
        int[] nxt;
        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                nx = now[0] + moves[i][0];
                ny = now[1] + moves[i][1];

                if (!isPossible(nx, ny))
                    continue;

                if (board[nx][ny] == std) {
                    board[nx][ny] ^= 1;
                    q.offer(new int[] { nx, ny });
                    res.add(new int[] { nx - a, ny - b });
                }
            }
        }

        if (std == 1)
            blocks.add(res);
        else
            blanks.add(res);

        return board;
    }

    static boolean isPossible(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < N);
    }
}