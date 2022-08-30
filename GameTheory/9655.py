N = int(input())
dp = [-1] * 999
dp = [1, 0, 1] + dp
for i in range(4, N+1):
    dp[i] = 0 if dp[i-1] or dp[i-3] else 1

print("SK" if dp[N] else "CY")
