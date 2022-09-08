from collections import deque

def solution(rectangle, characterX, characterY, itemX, itemY):
    M = 120
    board = [[0] * M for _ in range(M)]
    moves = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    visit = [[0] * M for _ in range(M)]
    
    #변수를 쓰기 좋게 바꾸자
    cx, cy = 2*characterY, 2*characterX
    ix, iy = 2*itemY, 2*itemX

    def BFS(x, y):
        q = deque()
        q.append((x, y, 0))
        visit[x][y] = 1
        
        while q:
            x, y, c = q.popleft()
            
            if x == ix and y == iy:
                return c//2
            
            for dx, dy in moves:
                nx = x + dx
                ny = y + dy
                
                if board[nx][ny] == 1 and visit[nx][ny] == 0:
                    q.append((nx, ny, c+1))
                    visit[nx][ny] = 1
        
    #사각형을 board 에 기록하자
    for x1, y1, x2, y2 in rectangle:
        for nx in range(2*y1, 2*y2+1):
            for ny in range(2*x1, 2*x2+1):
                board[nx][ny] = 1
    
    #테두리만 남기고 0으로 밀어버리자
    for x1, y1, x2, y2 in rectangle:
        for nx in range(2*y1+1, 2*y2):
            for ny in range(2*x1+1, 2*x2):
                board[nx][ny] = 0
        
    return BFS(cx, cy)