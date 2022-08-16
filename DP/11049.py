import sys
input = sys.stdin.readline

N = int(input())
nums = [list(map(int, input().split())) for _ in range(N)]
dp = [[0] * N for _ in range(N)]

for i in range(1, N):
    for j in range(N-i):
        t = i + j  
        dp[j][t] = 10e9
        for k in range(j, t):
            dp[j][t] = min(dp[j][t], dp[j][k] + dp[k+1][t] + nums[j][0] * nums[k][1] * nums[t][1])
    
print(dp[0][-1])