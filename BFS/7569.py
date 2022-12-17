import sys
from collections import deque
input= sys.stdin.readline

M, N, H = map(int, input().split())
board = []
moves = [(-1, 0, 0), (1, 0, 0), (0, -1, 0), (0, 1, 0), (0, 0, -1), (0, 0, 1)]
visit = [[[0]*M for _ in range(N)] for _ in range(H)]

q = deque()
for i in range(H):
    t = []
    for j in range(N):
        t.append(list(map(int, input().split())))
        for k in range(M):
            if t[j][k] == 1:
                q.append((i, j, k))
    board.append(t)

while q:
    h, x, y = q.popleft()

    for dx, dy, dh in moves:
        nx = x + dx
        ny = y + dy
        nh = h + dh

        if 0 <= nx < N and 0 <= ny < M and 0 <= nh < H:
            if board[nh][nx][ny] == 0:
                board[nh][nx][ny] = board[h][x][y] + 1
                q.append((nh, nx, ny))

res = 0
for i in range(H):
    for j in range(N):
        for k in range(M):
            if board[i][j][k] == 0:
                print(-1)
                exit()
      
        res = max(res, max(board[i][j]))

print(res-1)
