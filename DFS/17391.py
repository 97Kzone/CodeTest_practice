import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
visit = [[0 for _ in range(M)] for _ in range(N)]
visit[0][0] = 0

q = deque()
q.append((0, 0))

d = [(0, 1), (1, 0)]
while q:
    x, y = q.popleft()
    for i in range(2):
        nx, ny = x, y

        for j in range(board[x][y]):
            nx += d[i][0]
            ny += d[i][1]

            if 0 <= nx < N and 0 <= ny < M:
                if visit[nx][ny] == 0:
                    q.append((nx, ny))
                    visit[nx][ny] = visit[x][y] + 1

print(visit[-1][-1]) 