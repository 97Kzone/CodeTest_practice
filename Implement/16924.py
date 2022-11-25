import sys
from collections import deque
input = sys.stdin.readline
moves = [(-1, 0), (1, 0), (0, -1), (0, 1)]

def check(x, y):
    q = deque()

    for dr, d in enumerate(moves):
        nx = x + d[0]
        ny = y + d[1]

        if 0 <= nx < N and 0 <= ny < M:
            if board[nx][ny] == "*":
                q.append((nx, ny, dr))

    if len(q) == 4:
        visit[x][y] = 1
    else:
        return 0

    v = 1
    while len(q) == 4:
        for _ in range(4):
            x, y, d = q.popleft()
            visit[x][y] = 1

            nx = x + moves[d][0]
            ny = y + moves[d][1]
        
            if 0 <= nx < N and 0 <= ny < M:
                if board[nx][ny] == "*":
                    q.append((nx, ny, d))
        v += 1
    return v

N, M = map(int, input().split())
board = [list(input()) for _ in range(N)]
visit = [[0] * M for _ in range(N)]

res = []
cnt = 0
for i in range(N):
    for j in range(M):
        if board[i][j] == "*":
            cnt += 1
            v = check(i, j)
            if v:
                res.append((i+1, j+1, v-1))

std = 0
for r in visit:
    std += sum(r)

if cnt == std:
    print(len(res))
    for r in res:
        print(*r)
else:
    print(-1)
 