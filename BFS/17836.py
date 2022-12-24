import sys
from collections import deque
input = sys.stdin.readline
moves = [(-1, 0), (1, 0), (0, -1), (0, 1)]

def BFS():
    global res 

    q = deque()
    q.append((0, 0, 0)) # x, y, 시간
    visit[0][0] = 1
    while q:
        x, y, t = q.popleft()

        if x == N-1 and y == M-1:
            res = min(res, t)
        
        for dx, dy in moves:
            nx = x + dx
            ny = y + dy
            
            if 0 <= nx < N and 0 <= ny < M:
                if board[nx][ny] == 0:
                    if visit[nx][ny] == 0:
                        visit[nx][ny] = 1
                        q.append((nx, ny, t+1))
                elif board[nx][ny] == 2:
                    visit[nx][ny] = 1
                    res = min(res, t+N-nx+M-1-ny)

N, M, T = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
visit = [[0] * M for _ in range(N)]
res = 10001

BFS()
print(res if res <= T else "Fail")