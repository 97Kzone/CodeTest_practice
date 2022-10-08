import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
board = [list(input().rstrip()) for _ in range(N)]
moves = [(-1, 0), (1, 0), (0, -1), (0, 1)]

def DFS(x, y):
    global res
    visit = [[0] * M for _ in range(N)]
    visit[x][y] = 1

    q = deque([(x, y, 0)])

    while q:
        x, y, cnt = q.popleft()
        res = max(cnt, res)

        for dx, dy in moves:
            nx = x + dx
            ny = y + dy

            if 0 <= nx < N and 0 <= ny < M:
                if board[nx][ny] == "L" and visit[nx][ny] == 0:
                    q.append((nx, ny, cnt+1))
                    visit[nx][ny] = 1

res = 0
for i in range(N):
    for j in range(M):
        if board[i][j] == "L":
            DFS(i, j)

print(res)