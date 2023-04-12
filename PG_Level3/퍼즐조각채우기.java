package PG_Level3;

import java.util.*;

class 퍼즐조각채우기 {

}

class Solution {
    static List<List<int[]>> blocks; // 빈 공간, 블록을 담을 리스트
    static Set<List<int[]>> blank;
    static Queue<int[]> q = new ArrayDeque();
    static int N, answer; // 보드 크기
    static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] gboard;
    
    public int solution(int[][] game_board, int[][] table) {
        answer = 0;
        
        blocks = new ArrayList<>(); 
        blank = new HashSet<>();
        
        N = game_board.length;
        deepCopy(game_board);
        
        // 블록 추출하기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (table[i][j] == 1) table = findBlock(i, j, table, 1);
            }
        }
        
        // 돌려가면서 빈 공간 모든 좌표 뽑기
        for (int k = 0; k < 4; k++) {
            deepCopy(game_board);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (game_board[i][j] == 0) game_board = findBlock(i, j, game_board, 0);
                }
            }
            rotate();
            game_board = gboard;
        }
        
        
        // 빈 공간, 블록 사이즈 순 내림차 정렬
        blocks.sort((o1, o2) -> (o2.size() - o1.size()));
        
        // for (List<int[]> tmp : blank) {
        //     for (int[] n : tmp) {
        //         System.out.println(Arrays.toString(n));
        //     }
        //     System.out.println("------------");
        // }
        
        // 블록을 순차적으로 빈 공간과 매칭 해보기
        for (List<int[]> block : blocks) {
            check(block);
        }
        
        return answer;
    }    

    static void check(List<int[]> block) {
        boolean flag;
        
        for (List<int[]> now : blank) {
            
            if (now.size() != block.size()) continue; // 크기가 안맞으면 PASS
        
            flag = true;
            for (int j = 0; j < block.size(); j++) {
                if (now.get(j)[0] != block.get(j)[0] || now.get(j)[1] != block.get(j)[1]) {
                    flag = false;
                    break;
                }      
            }
            
            if (flag) {
                blank.remove(now);
                answer += block.size();
                return;
            }
        }
    }
    
    // game_board 오른쪽으로 90도 회전
    static void rotate() {
        int[][] tmp = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tmp[i][j] = gboard[N-1-j][i];
            }
        }
        
        gboard = tmp;
    }
    
    // 블록, 공간 찾기
    static int[][] findBlock(int a, int b, int[][] board, int std) {
        q.clear();
        List<int[]> res = new ArrayList<>(); // 합격한 좌표들 모음
        
        res.add(new int[] {a, b});
        q.offer(new int[] {a, b});
        
        board[a][b] ^= 1;
        
        int nx, ny;
        int[] nxt;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            
            for (int i = 0; i < 4; i++) {
                nx = now[0] + moves[i][0];
                ny = now[1] + moves[i][1];
                
                if (!isPossible(nx, ny)) continue;
                
                if (board[nx][ny] == std) {
                    board[nx][ny] ^= 1;
                    nxt = new int[] {nx, ny};   
                    res.add(nxt);
                    q.offer(nxt);
                }
            }
        }
        
        movePoint(res, std);
        return board;
    }
    
    
    // 블록 좌표 조정 + 리스트에 추가
    static void movePoint(List<int[]> list, int std) {
        List<int[]> res = new ArrayList<>();
        res.add(new int[] {0, 0});
        
        list.sort((o1, o2) -> (o1[0] - o2[0]));
        
        // 기준점
        int sx = list.get(0)[0];
        int sy = list.get(0)[1]; 
        
        int tx, ty;
        for (int i = 1; i < list.size(); i++) {
            tx = list.get(i)[0] - sx;
            ty = list.get(i)[1] - sy;
            
            res.add(new int[] {tx, ty});
        }
        
        if (std == 1) blocks.add(res);
        else blank.add(res);
    } 
    
    static void deepCopy(int[][] arr) {
        gboard = new int[N][N];
        for (int i = 0; i < N; i++) gboard[i] = arr[i].clone();
    }
    
    static boolean isPossible(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < N);
    }
}