import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline

def DFS(i, j):
    check[i][j] = 1

    for dx, dy in moves:
        nx = i + dx
        ny = j + dy

        if 0 <= nx < M and 0 <= ny < N:
            if board[nx][ny] == 1 and check[nx][ny] == 0:
                DFS(nx, ny)
    
M, N = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(M)]
check = [[0] * N for _ in range(M)]

moves = [(-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1)]
cnt = 0
for i in range(M):
    for j in range(N):
        if board[i][j] == 1 and check[i][j] == 0:
            DFS(i, j)
            cnt += 1

print(cnt) 