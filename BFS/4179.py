import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
board = [list(input().rstrip()) for _ in range(N)]
moves = [(-1, 0), (1, 0), (0, -1), (0, 1)]
visit = [[0] * M for _ in range(N)]

def BFS(start, fire):
    x, y = start
    q = deque()
    q.append((x, y, 0))
    q2 = deque(fire)
    visit[x][y] = 1

    while q:        
        #불 
        L = len(fire)
        for _ in range(L):
            x, y = q2.popleft()
            for dx, dy in moves:
                nx = x + dx
                ny = y + dy

                if 0 <= nx < N and 0 <= ny < M:
                    if board[nx][ny] == "." and visit[nx][ny] <= 1:
                        visit[nx][ny] = -1
                        board[nx][ny] = "F"
                        q2.append((nx, ny))

        x, y, c = q.popleft()
        if x == 0 or x == N-1 or y == 0 or y == M-1:
            return c+1

        #사람
        for dx, dy in moves:
            nx = x + dx
            ny = y + dy

            if 0 <= nx < N and 0 <= ny < M:
                if board[nx][ny] == "." and visit[nx][ny] == 0:
                    visit[nx][ny] = 1
                    q.append((nx, ny, c+1))

    return -1

fire = []
for i in range(N):
    for j in range(M):
        if board[i][j] == "J":
            start = [i, j]
            continue

        if board[i][j] == "F":
            fire.append((i, j))

res = BFS(start, fire)
print(res if res != -1 else "IMPOSSIBLE")
