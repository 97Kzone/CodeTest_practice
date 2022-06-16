import sys
input = sys.stdin.readline

N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]
dp = [[0] * N for _ in range(N)]
dp[0][0] = 1

for i in range(N):
    for j in range(N):
        v = board[i][j]

        if dp[i][j] != 0 and v != 0:
            if i + v < N:
                dp[i+v][j] += dp[i][j]
            
            if j + v < N:
                dp[i][j+v] += dp[i][j]

print(dp[-1][-1])
