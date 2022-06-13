from collections import deque
import sys

input = sys.stdin.readline

M, N = map(int, input().split())
box = [list(map(int, input().split())) for _ in range(N)]
move = [(-1, 0 ), (1, 0), (0, -1), (0, 1)]

def check(tomato, board, visited):
    q = deque(tomato)
    days = 0
    while q:
        x, y, days = q.popleft()

        for dx, dy in move:
            nx = x + dx
            ny = y + dy
            
            if 0 <= nx < N and 0 <= ny < M:
                if board[nx][ny] == 0 and visited[nx][ny] == 0:
                    q.append([nx, ny, days+1])
                    visited[nx][ny] = 1
    
    for i in range(N):
        for j in range(M):
            if visited[i][j] == 0:
                return -1

    return days

visit = [[0 for _ in range(M)] for _ in range(N)]
tmt = []
for i in range(N):
    for j in range(M):
        if box[i][j] == 1:
            tmt.append([i, j, 0])
            visit[i][j] = 1
        elif box[i][j] == -1:
            visit[i][j] = 1

res = check(tmt, box, visit)
print(res)