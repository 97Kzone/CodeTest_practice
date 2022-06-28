import sys
input = sys.stdin.readline

N = int(input())
nums = list(map(int, input().split()))

dp = [[0] * 21 for _ in range(N-1)]
dp[0][nums[0]] = 1

for i in range(1, N-1):
    for j in range(21):
        if dp[i-1][j] != 0:
            v1 = j + nums[i]
            v2 = j - nums[i]

            if v1 <= 20:
                dp[i][v1] += dp[i-1][j]
            
            if v2 >= 0:
                dp[i][v2] += dp[i-1][j]

print(dp[-1][nums[-1]])