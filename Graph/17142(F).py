import sys
from collections import deque
from itertools import combinations as cb
input = sys.stdin.readline

N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
moves = [(-1, 0), (1, 0), (0, -1), (0, 1)]
V = []

def bfs(std):
    q, r = deque(), 0

    for x, y in std:
        q.append((x, y))
        visit[x][y] = 0

    while q:
        x, y = q.popleft()

        for dx, dy in moves:
            nx = x + dx
            ny = y + dy

            if 0 <= nx < N and 0 <= ny < N:
                if visit[nx][ny] == -1:
                    if board[nx][ny] == 0:
                        q.append((nx, ny))
                        visit[nx][ny] = visit[x][y] + 1
                        r = max(r, visit[nx][ny])
                    elif board[nx][ny] == 2:
                        q.append((nx, ny))
                        visit[nx][ny] = visit[x][y] + 1
    
    return max(max(visit))

# 바이러스 위치 찾기
w = 0
for i in range(N):
    for j in range(N):
        if board[i][j] == 2:
            V.append((i, j))
        elif board[i][j] == 1:
            w += 1

res = 10e9
for on in list(cb(V, M)):
    visit = [[-1] * N for _ in range(N)]
    tmp = bfs(on)
    res = min(res, tmp)

print(res if res != 10e9 else -1)
