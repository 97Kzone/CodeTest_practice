N = int(input())

nums = list(map(int, input().split()))
dp = [[x for x in nums] for _ in range(2)]

for i in range(1, N):
    dp[0][i] = max(dp[0][i-1] + nums[i], nums[i])
    dp[1][i] = max(dp[0][i-1], dp[1][i-1] + nums[i])

print(max(max(dp[0]), max(dp[1])))