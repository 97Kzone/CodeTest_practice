import sys
input = sys.stdin.readline

moves = [(-1, 0), (1, 0), (0, -1), (0, 1)]
def cnt(x, y):
    for dx, dy in moves:
        nx = x + dx
        ny = y + dy

        if 0 <= nx < N and 0 <= ny < M:
            if board[x][y] >= board[nx][ny]:
                check[x][y] -= board[nx][ny]
            else:
                check[x][y] -= board[x][y]

N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
check = [[0] * M for _ in range(N)]

for i in range(N):
    for j in range(M):
        if board[i][j] == 1:
            check[i][j] = 6
        elif board[i][j] == 2:
            check[i][j] = 10
        else:
            check[i][j] = 10 + 4*(board[i][j]-2)

for i in range(N):
    for j in range(M):
        cnt(i, j)

res = 0
for r in check:
    res += sum(r)
print(res)