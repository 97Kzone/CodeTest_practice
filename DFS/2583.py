import sys
from collections import deque
input = sys.stdin.readline

def check(x1, y1, x2, y2):
    for i in range(x1, x2):
        for j in range(y1, y2):
            board[M-1-j][i-N] = 1

def BFS(i, j):
    q = deque()
    q.append([i, j])
    visit[i][j] = 1
    cnt = 1

    while q:
        x, y = q.popleft()
        for dx, dy in move:
            nx = x + dx
            ny = y + dy
        
            if 0 <= nx < M and 0 <= ny < N:
                if board[nx][ny] == 0 and visit[nx][ny] == 0:
                    q.append([nx, ny])
                    visit[nx][ny] = 1
                    cnt += 1
    
    res.append(cnt)

M, N, K = map(int, input().split())
board = [[0] * N for _ in range(M)]
visit = [[0] * N for _ in range(M)]
move = [(-1, 0), (1, 0), (0, -1), (0, 1)]

for _ in range(K):
    x1, y1, x2, y2 = map(int, input().split())
    check(x1, y1, x2, y2)

res = []
for i in range(M):
    for j in range(N):
        if board[i][j] == 0 and visit[i][j] == 0:
            BFS(i, j)

res.sort()
print(len(res))
print(" ".join(str(r) for r in res))