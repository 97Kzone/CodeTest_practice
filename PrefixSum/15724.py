import sys
input = sys.stdin.readline

N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]

check = [[0]*(M+1) for _ in range(N+1)]

for i in range(1, N+1):
    for j in range(1, M+1):
        check[i][j] = board[i-1][j-1] + check[i-1][j] + check[i][j-1] - check[i-1][j-1]

T = int(input())
for _ in range(T):
    a, b, c, d = map(int, input().split())
    print(check[c][d] - check[a-1][d] - check[c][b-1] + check[a-1][b-1])
