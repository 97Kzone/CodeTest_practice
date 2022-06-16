from collections import deque
import sys

N = int(input())
board = [list(sys.stdin.readline().rstrip()) for _ in range(N)]
check = [[0] * N for _ in range(N)]
dx = [[-1, 0], [1, 0], [0, -1], [0, 1]]

def bfs(i, j, color):
    q = deque()
    q.append([i, j])

    while q:
        x, y = q.popleft()

        if not check[x][y]:
            check[x][y] = 1
            for i in range(4):
                nx = x + dx[i][0]
                ny = y + dx[i][1]
                
                if 0 <= nx < N and 0 <= ny < N:
                    if board[nx][ny] == color:
                        q.append([nx, ny])
cnt, cnt2 = 0, 0
for i in range(N):
    for j in range(N):
        if not check[i][j]:
            c = board[i][j]
            bfs(i, j, c)
            cnt += 1

#적록색약 카운팅 준비
for i in range(N):
    for j in range(N):
        if board[i][j] == "G":
            board[i][j] = "R"
        
        check[i][j] = 0

for i in range(N):
    for j in range(N):
        if not check[i][j]:
            c = board[i][j]
            bfs(i, j, c)
            cnt2 += 1

print(cnt, cnt2)
