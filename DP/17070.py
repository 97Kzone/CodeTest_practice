import sys
input = sys.stdin.readline

N = int(input())

check = [[[0] * 3 for _ in range(N)] for _ in range(N+1)]
board = [list(map(int, input().split())) for _ in range(N)]
board.insert(0, [0]*N)
check[1][1] = [1, 0, 0]

for i in range(1, N+1):
    for j in range(1, N):
        if i == j == 1:
            continue

        if board[i][j] == 0:
            check[i][j][0] = check[i][j-1][0] + check[i][j-1][1]
            check[i][j][2] = check[i-1][j][1] + check[i-1][j][2]
            if board[i][j-1] == board[i-1][j] == 0:
                check[i][j][1] = sum(check[i-1][j-1])

print(sum(check[-1][-1]))