import sys
input = sys.stdin.readline

N, M, H = map(int, input().split())
blocks = [list(map(int, input().split())) for _ in range(N)]
dp = [[1] + ([0] * H) for _ in range(N+1)]

for i in range(1, N+1):
    dp[i] = dp[i-1].copy()
    for h in blocks[i-1]:
        for j in range(h, H+1):
            dp[i][j] += dp[i-1][j-h]


print(dp[-1][H]%10007)