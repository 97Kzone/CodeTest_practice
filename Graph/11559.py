import sys
from collections import deque
input = sys.stdin.readline

board = [list(input().rstrip("\n")) for _ in range(12)]
moves = [(-1, 0), (1, 0), (0, -1), (0, 1)]

def bfs(x, y):
    q = deque()
    q.append((x, y))
    tmp.append((x, y))
    
    while q:
        x, y = q.popleft()

        for dx, dy in moves:
            nx = x + dx
            ny = y + dy

            if 0 <= nx < 12 and 0 <= ny < 6:
                if visit[nx][ny] == 0:
                    if board[nx][ny] == board[x][y]:
                        q.append((nx, ny))
                        tmp.append((nx, ny))
                        visit[nx][ny] = 1

def build():
    for i in range(6):
        for j in range(10, -1, -1):
            for k in range(11, j, -1):
                if board[j][i] != "." and board[k][i] == ".":
                    board[k][i] = board[j][i]
                    board[j][i] = "."
                    break

res = 0
while True:
    visit = [[0] * 6 for _ in range(12)]
    trigger = False
    for i in range(12):
        for j in range(6):
            if board[i][j] != "." and visit[i][j] == 0:
                visit[i][j] = 1
                tmp = []
                bfs(i, j)

                if len(tmp) >= 4:
                    trigger = True
                    for x, y in tmp:
                        board[x][y] = "."

    if not trigger:
        break

    build()
    res += 1

print(res)