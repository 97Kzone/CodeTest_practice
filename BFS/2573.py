import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
moves = [(-1, 0), (1, 0), (0, -1), (0, 1)]

def BFS(x, y):
    q = deque()
    q.append((x, y))
    visit[x][y] = 1

    while q:
        x, y = q.popleft()

        for dx, dy in moves:
            nx = x + dx
            ny = y + dy

            if 0 <= nx < N and 0 <= ny < M:
                if board[nx][ny] != 0 and visit[nx][ny] == 0:
                    visit[nx][ny] = 1
                    q.append((nx, ny))
                elif board[nx][ny] == 0:
                    check[x][y] += 1

res = 0
while True:
    visit = [[0] * M for _ in range(N)] 
    check = [[0] * M for _ in range(N)]

    cnt = 0
    for i in range(N):
        for j in range(M):
            if board[i][j] != 0 and visit[i][j] == 0:
                BFS(i, j)
                cnt += 1

    for i in range(N):
        for j in range(M):
            tmp = board[i][j] - check[i][j]
            board[i][j] = tmp if tmp > 0 else 0
    
    
    if cnt == 0:
        print(0)
        break

    if cnt >= 2:
        print(res)
        break

    res += 1

        