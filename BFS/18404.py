import sys
from collections import deque
input = sys.stdin.readline
moves = [(-2, -1), (-1, -2), (-2, 1), (-1, 2), (1, -2), (1, 2), (2,-1), (2, 1)]

N, M = map(int, input().split())
x, y = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(M)]
visit = [[-1] * N for _ in range(N)]
visit[x-1][y-1] = 0

q = deque()
q.append((x-1, y-1))

while q:
    x, y = q.popleft()

    for dx, dy in moves:
        nx = x + dx
        ny = y + dy

        if 0 <= nx < N and 0 <= ny < N:
            if visit[nx][ny] == -1:
                q.append((nx, ny))
                visit[nx][ny] = visit[x][y] + 1

res = []
for x, y in board:
    res.append(visit[x-1][y-1])

print(*res)