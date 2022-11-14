from collections import deque

N = int(input())
moves = [(-1, 0), (1, 0), (0, -1), (0, 1)]

def BFS(i, j):
    global res

    q = deque()
    q.append((i, j))
    visit[i][j] = 1

    c = 1
    while q:
        x, y = q.popleft()

        for dx, dy in moves:
            nx = x + dx
            ny = y + dy

            if 0 <= nx < N and 0 <= ny < N:
                if board[nx][ny] == '1':
                    if not visit[nx][ny]:
                        c += 1
                        q.append((nx, ny))
                        visit[nx][ny] = 1
    
    res.append(c)

board = []
visit = [[0] * N for _ in range(N)]

check = []
res = []
for i in range(N):
    row = list(input())
    for j in range(N):
        if row[j] == '1':
            check.append((i, j))
    board.append(row)

for i, j in check:
    if not visit[i][j]:
        BFS(i, j)

res.sort()
print(len(res))
for v in res:
    print(v)