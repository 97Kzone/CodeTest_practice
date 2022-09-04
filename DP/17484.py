import sys
input = sys.stdin.readline

N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
dp = [[[1000, 1000, 1000] for _ in range(M)] for _ in range(N)]
dp[0][0][0] = board[0][0]
 
for i in range(N):
    if i == 0:
        for j in range(M):
            for k in range(3):
                dp[i][j][k] = board[i][j]
    else:
        for j in range(M):
            if j == 0:
                dp[i][j][0] = min(dp[i-1][j+1][1], dp[i-1][j+1][2]) + board[i][j]
                dp[i][j][1] = dp[i-1][j][0] + board[i][j]
            elif j == M-1:
                dp[i][j][1] = dp[i-1][j][2] + board[i][j]
                dp[i][j][2] = min(dp[i-1][j-1][0], dp[i-1][j-1][1]) + board[i][j]
            else:
                dp[i][j][0] = min(dp[i-1][j+1][1], dp[i-1][j+1][2]) + board[i][j]
                dp[i][j][1] = min(dp[i-1][j][0], dp[i-1][j][2]) + board[i][j]
                dp[i][j][2] = min(dp[i-1][j-1][0], dp[i-1][j-1][1]) + board[i][j]

res = 10000
for r in dp[-1]:
    for v in r:
        res = min(v, res)

print(res)