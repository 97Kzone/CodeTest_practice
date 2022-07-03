import sys
input =  sys.stdin.readline

N = int(input())
cost = [list(map(int, input().split())) for _ in range(N)]

ans = 1e10
for i in range(3):
    dp = [[1e10] * 3 for _ in range(N)]
    dp[0][i] = cost[0][i]
    
    for j in range(1, N):
        dp[j][0] = cost[j][0] + min(dp[j-1][1], dp[j-1][2])
        dp[j][1] = cost[j][1] + min(dp[j-1][0], dp[j-1][2])
        dp[j][2] = cost[j][2] + min(dp[j-1][0], dp[j-1][1])
    
    for j in range(3):
        if i != j:
            ans = min(ans, dp[-1][j])

print(ans)
    